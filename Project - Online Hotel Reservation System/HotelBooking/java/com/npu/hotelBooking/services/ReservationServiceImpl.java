package com.npu.hotelBooking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npu.hotelBooking.dao.ReservationDAO;
import com.npu.hotelBooking.domain.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	@Qualifier("reservationDaoJdbc")
	private ReservationDAO reservationDao;
	
	@Override
	@Transactional
	public void addReservation(Reservation res) {
		reservationDao.insertReservation(res);
		
	}

	@Override
	@Transactional
	public void removeReservation(String roomType) {
		reservationDao.deleteReservation(roomType);
	}
	@Override
	@Transactional
	public void removeReservation(int reservationID) {
		reservationDao.deleteReservationByID(reservationID);		
	}

	@Override
	@Transactional
	public Reservation viewAReservation(int id) {
		return reservationDao.findReservationById(id);
	}

	@Override
	@Transactional
	public Reservation updateReservation(Reservation reservation) {
		return reservationDao.updateReservation(reservation);
	}

	@Override
	@Transactional
	public Reservation invalidReservationID(int reservationID) {
		return reservationDao.getAReservation(reservationID);
	}

	

}
