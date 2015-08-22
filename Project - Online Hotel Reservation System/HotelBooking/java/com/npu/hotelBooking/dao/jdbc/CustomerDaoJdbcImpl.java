package com.npu.hotelBooking.dao.jdbc;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.npu.hotelBooking.dao.CustomerDAO;
import com.npu.hotelBooking.domain.Customer;
import com.npu.hotelBooking.exceptions.CustomerDaoCheckedException;
import com.npu.hotelBooking.exceptions.CustomerDaoRuntimeException;

import edu.mrv.carrental.dao.CustomerMapper;



@Repository("customerDaoJdbc")
@Component
//@Transactional
public class CustomerDaoJdbcImpl implements CustomerDAO {
	@Autowired
	@Qualifier("dataSource")
	private BasicDataSource dataSource;
	

	private JdbcTemplate jdbcTemplate;
	private JdbcTemplate jdbcTemplateObject;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private CustomerRowMapper customerRowMapper;

	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		//customerRowMapper = new CustomerRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("customer")
				.usingGeneratedKeyColumns("customerID")
				.usingColumns("firstName" , "lastName" , "phoneNumber" , "emailAddress", "mailingAddress");
		customerRowMapper = new CustomerRowMapper();
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int getCustomerCount() {
		String sql = "select count(*) FROM customer";
		return jdbcTemplate.queryForInt(sql);

	}
	@Override
	public void insertInfo(Customer newCust)   {
				
		SqlParameterSource  params = new BeanPropertySqlParameterSource(newCust);
		Number newId = jdbcInsert.executeAndReturnKey(params);
		newCust.setcustomerID(newId.intValue());
	}
	@Override
	public Customer getACustomer(int custid) 
	{
		Customer customer = null;
		try
		{
		
			String SQL = "select * from Customer where customerID = ?";
		    customer= jdbcTemplateObject.queryForObject(SQL, new Object[]{custid}, new CustomerRowMapper());
		} 
		catch (EmptyResultDataAccessException e) 
		{
			System.out.println("Empty Result !");
		}
		return customer;
	}
	
	@Override
	public Customer findCusByID(int ID) {
		String sql = "SELECT * FROM customer WHERE customerID = ?";
		Customer cust = jdbcTemplate.queryForObject(sql, customerRowMapper, ID);
	
		return cust;
	}

	@Override
	public Customer findCusByLasttName(String lastName) {
		
		String sql = "select * from Customer where lastName = ?";
		Customer customer = jdbcTemplate.queryForObject(sql, customerRowMapper, lastName);
		return customer;
	}

	@Override
	public Customer findCusByFirstName(String firstName) {
		String sql = "select * from Customer where firstName = ?";
		Customer customer = jdbcTemplate.queryForObject(sql, customerRowMapper, firstName);
		return customer;
	}

	@Override
	public int upateCustomerNum(String newName, String oldName) {
		String sql = "update customer set firstName =? where firstName= ?";
		int rowsChanged = jdbcTemplate.update(sql, newName, oldName);
		return rowsChanged;
	}
	@Override
	public Customer updateCustomer(Customer cust) {
		String sql = "Update customer set firstName = ? , lastName = ?, phoneNumber =? ,  emailAddress =?, mailingAddress =?  where customerID =? ";
		 jdbcTemplate.update( sql, cust.getFirstName() , cust.getLastName(), cust.getPhoneNumber(), cust.getEmailAddress(),cust.getMailingAddress(),cust.getcustomerID());
		return getACustomer(cust.getcustomerID());
		
		
	//	String SQL = "Update customer set lastName = ? ,firstName = ? , drivLicNum  = ?,email = ? , address = ? , city = ? , state = ? ,zipCode  = ?  WHERE customerID = ?";  
		//jdbcTemplateObject.update(SQL,cust.getLastName(),cust.getFirstName(), cust.getDrivLicNum(),cust.getEmail(),cust.getAddress(), cust.getCity(), cust.getState(),cust.getZipCode(),cust.getCustomerID() );
//					
//					 System.out.println("Updated Record with ID = " + cust.getCustomerID());
//				    return getACustomer(cust.getCustomerID());
		
		
	}
	@Override
	public int deleteCustomerName(String firstName) {
		String sql = "delete from customer where firstName = ?";
		int rowsRemoved = jdbcTemplate.update(sql, firstName);
		return rowsRemoved;
	}
	@Override
	public int deleteCustomer(int id) {
		String sql = "delete from customer where customerID = ?";
		int rowsRemoved = jdbcTemplate.update(sql, id);
		return rowsRemoved;
		
	}

	@Override
	public void insertCustomer(Customer cust1, Customer cust2) throws CustomerDaoCheckedException {
		SqlParameterSource params;
		Number newId;
		
		/*  Insert first Customer */
		params = new BeanPropertySqlParameterSource(cust1);
		newId = jdbcInsert.executeAndReturnKey(params);
		cust1.setcustomerID(newId.intValue());
		
		if (cust2== null) {
		throw new CustomerDaoRuntimeException("Attempt to insert null Customer");
		
		}

		
		/*  Insert second Customer */
		params = new BeanPropertySqlParameterSource(cust2);
		newId = jdbcInsert.executeAndReturnKey(params);
		cust2.setcustomerID(newId.intValue());
		
	}

}
