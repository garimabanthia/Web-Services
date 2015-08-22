package com.npu.hotelBooking.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.npu.hotelBooking.domain.Customer;
import com.npu.hotelBooking.services.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;


	// Insert Customer
	@RequestMapping(value = "/customer/insertNewCustomerDataForm" , method = RequestMethod.GET)
	public ModelAndView newCustomerData() {
		ModelAndView modelView;

		modelView = new ModelAndView("/customer/insertNewCustomerDataForm");
		modelView.addObject ("customer", new Customer());
		return modelView;
	}
	//Insert Costumer and success page
	@RequestMapping(value = "/customer/processNewCustomerProfile", method = RequestMethod.POST)
	public ModelAndView  processNewCustomerForm(@Valid Customer customer, BindingResult result, HttpSession session) {
		ModelAndView modelView;

		if (result.hasErrors()) {
			modelView = new ModelAndView("customer/insertNewCustomerDataForm");
			return modelView;
		}
		customerService.addCustomer(customer);
		modelView = new ModelAndView("customer/insertNewCustomerProfileSuccess");
		session.setAttribute("customer", customer);
		modelView.addObject("customer", customer);
		return modelView;
	}

	//Delete Customer
	@RequestMapping(value = "/customer/removeCustomerDataPage", method = RequestMethod.GET)
	public ModelAndView removeCustomerPage() {
		ModelAndView modelView;
		modelView = new ModelAndView("customer/deleteCustomerDataPage");
		modelView.addObject("customer", new Customer());

		return modelView;
	}
	//Delete Customer and Success Page
	@RequestMapping(value = "/customer/removeCustomerByName", method = RequestMethod.GET)
	public ModelAndView removeCustomerByName(@RequestParam (value = "firstName") String firstName) {
		customerService.removeCustomer(firstName);
		ModelAndView modelView = new ModelAndView("customer/deleteCustomerProfileSuccess");
		modelView.addObject("firstName",firstName);
		return modelView;
	}

	// select Customer 
	@RequestMapping(value = "/customer/selectACustomerID", method = RequestMethod.GET)
	public ModelAndView getACustomer() {
		ModelAndView modelView;
		modelView = new ModelAndView("customer/selectACustomerID");
		modelView.addObject("customer", new Customer());
		return modelView;
	}
	// Select customer Page and Display Success Page
	@RequestMapping(value = "/customer/viewACustomer", method = RequestMethod.GET)
	public ModelAndView viewCustomerDetail(@RequestParam (value = "customerID") String customerID) 
	{
		ModelAndView modelView;

		int id = Integer.parseInt(customerID);
		Customer customer;
		
		try{
			customer = customerService.viewACustomer(id);
		}catch(EmptyResultDataAccessException ex){
			return new ModelAndView("/reservation/pageNotFound");
		}
		modelView = new ModelAndView("customer/selectACustomer");
		modelView.addObject("customer", customer);
		return modelView;
	}

	// Update Customer Using ID
	@RequestMapping(value = "/customer/updateCustomerGetID", method = RequestMethod.GET)
	public ModelAndView updateACustomergetID() {
		ModelAndView modelView;

		modelView = new ModelAndView("customer/updateGetCustomerID");
		modelView.addObject("customer", new Customer());
		return modelView;
	}

	//update Customer and Success Page
	@RequestMapping(value = "/customer/updateCustomerData", method = RequestMethod.GET)
	public ModelAndView updateACustomer(@RequestParam (value = "customerID") String customerID) {
		ModelAndView modelView;

		int id = Integer.parseInt(customerID);

		Customer customer;
		try {
			customer= customerService.viewACustomer(id);
		}catch(EmptyResultDataAccessException ex){
			return new ModelAndView("reservation/pageNotFound");
		}
		modelView = new ModelAndView("customer/updateCustomerDataForm");
		modelView.addObject("customer", customer);
		return modelView;
	}
	@RequestMapping(value = "/customer/updateCustomerSuccess", method = RequestMethod.POST)
	public ModelAndView updateCustomerDetail(@Valid Customer customer, BindingResult result) 
	{
		ModelAndView modelView;
		Customer cust = customerService.updateCustomer(customer);
		modelView = new ModelAndView("customer/updateCustomerSuccess");
		modelView.addObject("customerID", cust.getcustomerID());
		return modelView;
	}

}

