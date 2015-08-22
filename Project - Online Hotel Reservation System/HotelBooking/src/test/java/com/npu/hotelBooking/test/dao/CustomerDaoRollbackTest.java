package com.npu.hotelBooking.test.dao;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.npu.hotelBooking.dao.CustomerDAO;
import com.npu.hotelBooking.domain.Customer;
import com.npu.hotelBooking.exceptions.CustomerDaoCheckedException;
import com.npu.hotelBooking.exceptions.CustomerDaoRuntimeException;

@ContextConfiguration(locations = "classpath:hoteldao-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDaoRollbackTest {

	private Logger custLogger = Logger.getLogger(CustomerDaoRollbackTest.class);

	@Autowired
	private CustomerDAO customerDao;

	private Customer customer;

	// @Before
	// public void init() {
	// customer = new Customer();
	// customer.setAddress("San Jose");
	// customer.setEmailAddress("abc123@sde.com");
	// customer.setFirstName("Mishu");
	// customer.setLastName("Dagaria");
	// customer.setPhoneNumber("408-839-8580");
	// }

	@Test
	public void testNullCustomerInsert() throws CustomerDaoCheckedException {
		int origCustCnt, newCustCnt;
		customer = new Customer();

		customer.setMailingAddress("Fremont");
		customer.setEmailAddress("abc123@sde.com");
		customer.setFirstName("Bunty");
		customer.setLastName("Banthia");
		customer.setPhoneNumber("408-839-8580");

		origCustCnt = customerDao.getCustomerCount();
		System.out.println("origCustCnt:  " + origCustCnt);

		try {
			customerDao.insertCustomer(customer, null);
			custLogger.info("Unexpected Successful insertion");
			// fail();
		} catch (CustomerDaoRuntimeException ex) {
			custLogger.info("Insert Failed   The exception is:" + ex);
		}
		newCustCnt = customerDao.getCustomerCount();
		System.out.println("newCustCnt:  " + newCustCnt);
		assertTrue((origCustCnt+1) == newCustCnt);

	}

}
