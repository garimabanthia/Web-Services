package com.npu.hotelBooking.services;

import com.npu.hotelBooking.domain.Reservation;

public interface ReservationService {
	public void addReservation (Reservation res);
	public void removeReservation(String roomType);
	public void removeReservation(int reservationID);
	public Reservation viewAReservation (int id);
	public Reservation updateReservation (Reservation reservation);
	public Reservation invalidReservationID(int reservationID);
	

}
