package com.npu.hotelBooking.dao.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.npu.hotelBooking.domain.*;

public class ReservationRowMapper implements RowMapper<Reservation> {

	@Override
	public Reservation mapRow(ResultSet resultSet, int row) throws SQLException {
		Reservation reservation = new Reservation() ;
		
		reservation.setReservationID(resultSet.getInt("reservationID"));
		reservation.setRoomType(resultSet.getNString("roomType"));
		reservation.setCheckINDate(resultSet.getDate("checkINDate"));
		reservation.setCheckOUTDate(resultSet.getDate("checkOUTDate"));
		reservation.setAmountPaid(resultSet.getDouble("amountPaid"));		
		reservation.setTotalAmount(resultSet.getDouble("totalAmount"));
		
		return reservation;
	}

}
