 package com.npu.hotelBooking.dao.jdbc;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.npu.hotelBooking.dao.ReservationDAO;
import com.npu.hotelBooking.domain.Reservation;

import edu.mrv.carrental.dao.CarMapper;
import edu.mrv.carrental.domain.Car;


@Repository("reservationDaoJdbc")
@Component
public class ReservationDaoJdbcImpl implements ReservationDAO {
	@Autowired
	@Qualifier("dataSource")
	private BasicDataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	private JdbcTemplate jdbcTemplateObject;
	 
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private ReservationRowMapper reservationRowMapper;

	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("reservation")
				.usingGeneratedKeyColumns("reservationID")
				.usingColumns("roomType" , "checkINDate" , "checkOUTDate" , "amountPaid", "totalAmount");
		reservationRowMapper = new ReservationRowMapper();
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	
	@Override
	public void insertReservation(Reservation newReservation) {
			
		SqlParameterSource params = new BeanPropertySqlParameterSource(newReservation);
		Number newId = jdbcInsert.executeAndReturnKey(params);
		newReservation.setReservationID(newId.intValue());

	}

	@Override
	public int getReservationCount() {
		String sql = "select count(*) FROM reservation";
		return jdbcTemplate.queryForInt(sql);

	}

	@Override
	public Reservation findBookedRoomByRoomType(String roomType) {
		String sql ="SELECT * FROM reservation WHERE roomType= ?";
		Reservation res = jdbcTemplate.queryForObject(sql,reservationRowMapper, roomType);
		
		return res;
	}

	@Override
	public Reservation findReservationFullAmount(double totalAmount) {
		String sql = "select * from reservation where   totalAmount=? " ;
		return  jdbcTemplate.queryForObject(sql, reservationRowMapper, totalAmount );
	}


	@Override
	public Reservation findReservationById(int reservationId) {
		String sql = "select * from reservation where reservationID=? " ;
		return jdbcTemplate.queryForObject(sql, reservationRowMapper, reservationId);
	}


	@Override
	public Reservation findReservationLessThanTotalAmount(double amountPaid) {
		String sql = "select * from reservation where   amountPaid<? " ;
		return  jdbcTemplate.queryForObject(sql, reservationRowMapper, amountPaid );
	}


	@Override
	public int updateReservation(String newRoomType , String oldRoomType) {
		String sql = "update reservation set roomType =? where roomType =?";
		int rowsChanged = jdbcTemplate.update(sql,oldRoomType, newRoomType);
		return rowsChanged;
	}
	
	@Override
	public Reservation getAReservation(int reservationID) {
		{
			Reservation reservation = null;
			try
			{
			
				String SQL = "select * from reservation where reservationID = ?";
				reservation= jdbcTemplateObject.queryForObject(SQL, new Object[]{reservationID}, new ReservationRowMapper());
			} 
			catch (EmptyResultDataAccessException e) 
			{
				System.out.println("Empty Result!");
			}
			return reservation;
		}
		
//		
//		if (reservation !=null) {
//			String SQL = "select * from reservation where reservationID = ?";
//			reservation= jdbcTemplateObject.queryForObject(SQL, new Object[]{reservationID}, new ReservationRowMapper());
//		return reservation;
	//	}
	// 
//		
		
		
	
	}
	@Override
	public Reservation updateReservation(Reservation reservation) {
	
		String SQL="UPDATE `cs548_hotel`.`reservation` SET "
				+ " `roomType` = ? ,"
				+ " `checkINDate` = ?,"
				+ " `checkOUTDate` = ?,"
				+ " `amountPaid` = ?,"
				+ " `totalAmount` = ? WHERE `reservation`.`reservationID` =?;";
				
		jdbcTemplateObject.update(SQL,
				reservation.getRoomType(),
				reservation.getCheckINDate(),
				reservation.getCheckOUTDate(),
				reservation.getAmountPaid(),
				reservation.getTotalAmount(),
				reservation.getReservationID());
		
		 System.out.println("Updated Record with ID = " + reservation.getReservationID());
	    return getAReservation(reservation.getReservationID());
		
	}


	@Override
	public int deleteReservation(String roomType) {
		String sql = "delete from reservation where roomType = ?";
		int rowsRemoved = jdbcTemplate.update(sql, roomType);
		return rowsRemoved;
	}


	@Override
	public int deleteReservationByID(int reservationID) {
		String sql = "delete from reservation where reservationID  = ?";
		int rowsRemoved = jdbcTemplate.update(sql, reservationID);
		return rowsRemoved;
		
	}


	

}
