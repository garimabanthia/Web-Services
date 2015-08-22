package com.npu.hotelBooking.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.npu.hotelBooking.domain.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet resultSet, int row) throws SQLException {
		Customer customer;
		 
		customer = new Customer();
		customer.setcustomerID(resultSet.getInt ("customerID"));
		customer.setFirstName(resultSet.getString("firstName"));
		customer.setLastName(resultSet.getString("lastName"));
		customer.setPhoneNumber(resultSet.getString("phoneNumber"));
		customer.setEmailAddress(resultSet.getString("emailAddress"));
		customer.setMailingAddress(resultSet.getString("mailingAddress"));
	
		return customer;
	}

}