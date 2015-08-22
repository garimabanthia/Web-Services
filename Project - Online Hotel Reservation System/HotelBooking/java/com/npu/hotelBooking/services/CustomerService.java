package com.npu.hotelBooking.services;

//import java.util.ArrayList;

import com.npu.hotelBooking.domain.Customer;
import com.npu.hotelBooking.domain.Reservation;



public interface CustomerService {
	//public ArrayList <Customer> getReservedCustomer(String lastName);
	public void addCustomer (Customer cus);
	public void removeCustomer(String firstName);
	public void removeCustomer (int id);
	public Customer viewACustomer(int id);
	public Customer updateCustomer(Customer cust);

}