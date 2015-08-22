package com.npu.hotelBooking.test.dao;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.npu.hotelBooking.dao.ReservationDAO;
import com.npu.hotelBooking.domain.Reservation;


@ContextConfiguration(locations ="classpath:hoteldao-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ReservationDaoTest {

	@Autowired
	private ReservationDAO reservationDao;

	@Test 
	public void getCount() {
		int cnt = reservationDao.getReservationCount();
		System.out.println("Total Count of the Reservations: " + cnt);
	}

	@Test
	public void testInsertReservation () {
		Reservation res = new Reservation();

		GregorianCalendar today = new GregorianCalendar();
		Date todayDate = today.getTime();

			
		res.setRoomType("Suite");
		res.setCheckINDate(todayDate);
		res.setCheckOUTDate(todayDate);
		res.setAmountPaid(150);
		res.setTotalAmount(5000);

		reservationDao.insertReservation(res);

		System.out.println("Insert Rservation: " + res);
	}

	@Test
	public void testFindRoomByType(){
		Reservation res = reservationDao.findBookedRoomByRoomType("Suite");
		System.out.println("Search by Room Type: "  +res);
	  }

	@Test
	public void testTotalAmountPaid() {
		Reservation res = reservationDao.findReservationFullAmount(1000);
		System.out.println("Reservation of Total Amount Paid: " + res);
	}
	
	@Test
	public void testFindReservationByID(){
		Reservation res = reservationDao.findReservationById(10);
		System.out.println("Search Reservation by ID:  " + res);
	}
	

	@Test
	public void testUpdateRoomType() {
		//int expectedRowChange =1;
		int rowsChanged = reservationDao.updateReservation("Luxury", "Deluxe");
		//assertEquals(rowsChanged,expectedRowChange);
		
		System.out.println("Rows Changed in Updation : " + rowsChanged);
	}
	
//	@Test
//	public void testDeleteByRoomType()
//	{
//		//int expectedrowdeleted =1;
//		int rowsdeleted = reservationDao.deleteReservation("Suite");
//		//assertEquals(rowsdeleted ,expectedrowdeleted);
//		System.out.println("Rows Changed in Deletion : " + rowsdeleted);
//	}
//	@Test
//	public void testLessThanTotalAmount() {
//		Reservation res = reservationDao.findReservationLessThanTotalAmount(50);
//		System.out.println("Reservation of  Amount Paid: " + res);
//	}
	
	
	
	
}
