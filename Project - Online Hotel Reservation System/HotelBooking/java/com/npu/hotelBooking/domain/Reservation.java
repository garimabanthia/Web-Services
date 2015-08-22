package com.npu.hotelBooking.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Reservation {

	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ", roomType="
				+ roomType + ", checkInDate=" + checkINDate + ", checkOutDate="
				+ checkOUTDate + ", amountPaid=" + amountPaid
				+ ", totalAmount=" + totalAmount + "]";
	}

	private int reservationID;
	@NotEmpty
	private String roomType;
	//@NotEmpty
	private Date checkINDate;
	//@NotEmpty
	private Date checkOUTDate;
	private double amountPaid;
	//@Size(min =2 , max =5)
	private double totalAmount;

	public Reservation() {

	}

	public Reservation(int reservationID) {
		// super();
		this.reservationID = reservationID;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Date getCheckINDate() {
		return checkINDate;
	}

	public void setCheckINDate(Date checkInDate) {
		this.checkINDate = checkInDate;
	}
	
	public void setCheckINDate(String checkInDate) throws ParseException {
		this.checkINDate = new SimpleDateFormat("dd.MM.yyyy").parse(checkInDate);
	}

	public Date getCheckOUTDate() {
		return checkOUTDate;
	}

	public void setCheckOUTDate(Date checkOutDate) {
		this.checkOUTDate = checkOutDate;
		
	}
	
	public void setCheckOUTDate(String checkOutDate) throws ParseException {
		this.checkOUTDate = new SimpleDateFormat("dd.MM.yyyy").parse(checkOutDate);;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
