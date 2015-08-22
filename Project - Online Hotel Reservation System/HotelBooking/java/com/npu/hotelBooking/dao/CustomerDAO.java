package com.npu.hotelBooking.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.npu.hotelBooking.domain.Customer;
import com.npu.hotelBooking.exceptions.CustomerDaoCheckedException;
import com.npu.hotelBooking.exceptions.CustomerDaoRuntimeException;

@Component
public interface CustomerDAO {
	
	public Customer findCusByFirstName (String firstName);
	public Customer findCusByLasttName (String lastName) ;
	public Customer findCusByID (int ID);
	public void insertInfo  (Customer newCust) ;
	public int getCustomerCount() ;
	public Customer getACustomer(int custid) ;
	public int upateCustomerNum(String newName, String oldName);
	public Customer updateCustomer (Customer cust);
	public int deleteCustomerName(String firstName);
	public int deleteCustomer(int id);
	public void insertCustomer(Customer cust1, Customer cust2 ) throws CustomerDaoCheckedException;

}
