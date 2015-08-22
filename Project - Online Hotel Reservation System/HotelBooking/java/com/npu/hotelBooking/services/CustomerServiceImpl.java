package com.npu.hotelBooking.services;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.npu.hotelBooking.domain.Customer;
import com.npu.hotelBooking.dao.CustomerDAO;;



@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
@Qualifier("customerDaoJdbc")
private CustomerDAO customerDao;
	
	@Override
	@Transactional
	public void addCustomer(Customer cus) {
		customerDao.insertInfo(cus);
		
	}

	@Override
	@Transactional
	public void removeCustomer(String firstName) {
		customerDao.deleteCustomerName(firstName);
	}
	@Override
	@Transactional
	public void removeCustomer(int id) {
		customerDao.deleteCustomer(id);
		
	}

	@Override
	@Transactional
	public Customer viewACustomer(int id) {
		return customerDao.findCusByID(id);
		 
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer cust) {
		return customerDao.updateCustomer(cust);
	
	}

	

}
