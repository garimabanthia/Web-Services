package com.npu.hotelBooking.dao;

import org.springframework.stereotype.Component;

import com.npu.hotelBooking.domain.Reservation;

import edu.mrv.carrental.domain.Car;
@Component
public interface ReservationDAO {
	
	public void insertReservation (Reservation newReservation);
	public int getReservationCount() ;
	public Reservation findBookedRoomByRoomType(String roomType);
	public Reservation findReservationById (int reservationId);
	public Reservation findReservationFullAmount(double totalAmount);
	public Reservation findReservationLessThanTotalAmount(double amountPaid);
	public Reservation updateReservation (Reservation reservation);
	public int updateReservation(String newRoomType , String oldRoomType);
	public int deleteReservation (String roomType);
	public int deleteReservationByID (int reservationID);
	public Reservation getAReservation(int reservationID); 
	
}
