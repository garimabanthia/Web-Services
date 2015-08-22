package com.npu.hotelBooking.test.dao;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.npu.hotelBooking.dao.CustomerDAO;
import com.npu.hotelBooking.domain.Customer;
import com.npu.hotelBooking.exceptions.CustomerDaoCheckedException;
import com.npu.hotelBooking.exceptions.CustomerDaoRuntimeException;

import org.apache.log4j.Logger;

@ContextConfiguration(locations ="classpath:hoteldao-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class CustomerDAOTest {

	@Autowired
	private CustomerDAO customerDao;

		
	@Test
		public void testInsertCustomer () { 
		Customer cust = new Customer();
		//Customer cust = new Customer("Garima", "Dagaria","234-3451-345" ,"abz@xcy.com", "san Francisco");
		cust.setFirstName("Garima");
		cust.setLastName("Banthia");
		cust.setPhoneNumber("408-839-8580");
		cust.setEmailAddress("dagaria.garima@gmail.com");
		cust.setMailingAddress("San Jose");
		
		customerDao.insertInfo(cust);
		
		System.out.println("Insert Customer: " +cust);
	}

	@Test 
	public void getCount() {
		int cnt = customerDao.getCustomerCount();
		System.out.println("Total Count of the customers: " +cnt);
	}

	@Test 
	public void testFindCustomerByID() {
		Customer customer = customerDao.findCusByID(104);
		System.out.println("Search by ID: "+customer);
	}

	@Test
	public void testFindCustomerByLastName() {
		Customer customer  =customerDao.findCusByLasttName("singh");
		System.out.println("Search by Last Name: "+customer);

	}
	@Test
	public void testFindCustomerByFirstName() {
		Customer customer  =customerDao.findCusByFirstName("Swapna");
		System.out.println("Search by First Name: "+customer);
	}
	
	@Test
	public void testUpdateCustomerName() {
		//int expectedRowChange =1;
		int rowsChanged = customerDao.upateCustomerNum("Mishu", "Mishika");
		//assertEquals(rowsChanged,expectedRowChange);
		
		System.out.println("Rows Changed in Updation : " + rowsChanged);
	}
	
	@Test
	public void testDeleteByCustomerName()
	{
		//int expectedrowdeleted =1;
		int rowsdeleted = customerDao.deleteCustomerName(" ");
		//assertEquals(rowsdeleted ,expectedrowdeleted);
		System.out.println("Rows Changed in Deletion : " + rowsdeleted);
	}

	
	}