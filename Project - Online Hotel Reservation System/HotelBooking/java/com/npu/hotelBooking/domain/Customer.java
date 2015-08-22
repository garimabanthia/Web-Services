package com.npu.hotelBooking.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Customer {
		
	private int customerID;
	@Size(min =2, max=10)
	private String firstName;
	@Size(min =2, max=10)
	private String lastName;
	@NotEmpty
	private String mailingAddress;
	//@Range(max=12)
	private String phoneNumber ;
	@NotEmpty
	private String emailAddress;
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Customer( /*int customerID,*/String firstName, String lastName,
			String phoneNumber, String emailAddress, String mailingAddress ) {
		//super();
		//this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.mailingAddress = mailingAddress;
	}

	public Customer () {
		
	}

	public Customer(int customerID, String firstName, String lastName) {
		//super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public int getcustomerID() {
		return customerID;
	}
	public void setcustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return mailingAddress;
	}
	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

//	public void setAddress(String address) {
//		this.mailingAddress = address;
//	}
	public String getPhoneNumber1() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName="
				+ firstName + ", lastName=" + lastName + ", mailingAddress="
				+ mailingAddress + ", phoneNumber=" + phoneNumber
				+ ", emailAddress=" + emailAddress + "]";
	}
	
	

}
