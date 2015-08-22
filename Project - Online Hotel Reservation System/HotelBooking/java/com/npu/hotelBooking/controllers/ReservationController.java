package com.npu.hotelBooking.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.npu.hotelBooking.domain.Reservation;
import com.npu.hotelBooking.services.ReservationService;



@Controller
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	// Insert Reservation
	@RequestMapping(value = "/reservation/insertNewReservationDataForm", method = RequestMethod.GET)
	public ModelAndView newReservationDataForm() {
		ModelAndView modelView;

		modelView = new ModelAndView(
				"/reservation/insertNewReservationDataForm");
		modelView.addObject("reservation", new Reservation());
		return modelView;
	}

	// Insert Reservation and success page
	@RequestMapping(value = "/reservation/processNewReservationProfile", method = RequestMethod.POST)
	public ModelAndView processNewReservationForm(@Valid Reservation reservation, BindingResult result,
			HttpSession session) {
		ModelAndView modelView;
		
			if (result.hasErrors()) {
			modelView = new ModelAndView("reservation/insertNewReservationDataForm");
			return modelView;
		}
		reservationService.addReservation(reservation);
		modelView = new ModelAndView("reservation/insertNewReservationProfileSuccess");
		session.setAttribute("reservation", reservation);
		modelView.addObject("reservation", reservation);
		return modelView;
	}

	// Delete Reservation

	@RequestMapping(value = "/reservation/removeReservationDataPage", method = RequestMethod.GET)
	public ModelAndView removeReservationPage() {
		ModelAndView modelView;
		modelView = new ModelAndView("reservation/deleteReservationDataPage");
		modelView.addObject("reservation", new Reservation());

		return modelView;
	}

	// Delete Reservation and Success Page
	@RequestMapping(value = "/reservation/removeReservationByID", method = RequestMethod.GET)
	public ModelAndView removeReservationByType(@RequestParam(value = "reservationID") String reservationID) {

		int id = Integer.parseInt(reservationID);
		reservationService.removeReservation(id);
		ModelAndView modelView = new ModelAndView("reservation/deleteReservationProfileSuccess");
		modelView.addObject("reservationID", reservationID);
		return modelView;
	}

	// Select Reservation
	@RequestMapping(value = "/reservation/selectAReservationID", method = RequestMethod.GET)
	public ModelAndView getAReservation() {
		ModelAndView modelView;

		modelView = new ModelAndView("reservation/selectAReservationID");
		modelView.addObject("reservation", new Reservation());
		return modelView;
	}

	@RequestMapping(value = "/reservation/viewAReservation", method = RequestMethod.GET)
	public ModelAndView viewReservationDetail(@RequestParam(value = "reservationID") String reservationID) {
		ModelAndView modelView;
		
		int id = Integer.parseInt(reservationID);
		Reservation reservation;
		
		try {
			reservation = reservationService.viewAReservation(id);
		} catch(EmptyResultDataAccessException ex){
			return new ModelAndView("reservation/pageNotFound");
		} 	
		modelView = new ModelAndView("reservation/selectAReservation");
		modelView.addObject("reservation", reservation);
		return modelView;

	}

	// update Reservation. Take ReservationID to Display
	@RequestMapping(value = "/reservation/updateReservationGetID", method = RequestMethod.GET)
	public ModelAndView updateAReservationgetID() {
		ModelAndView modelView;

		modelView = new ModelAndView("reservation/updateGetReservationID");
		modelView.addObject("reservation", new Reservation());
		return modelView;
	}

	// update Reservation page to display
	@RequestMapping(value = "/reservation/updateReservationData", method = RequestMethod.GET)
	public ModelAndView updateAReservation(@RequestParam(value = "reservationID") String reservationID) {
		ModelAndView modelView;
		Reservation reservation;
		int id = Integer.parseInt(reservationID);
		try {
			reservation = reservationService.viewAReservation(id);
		} catch(EmptyResultDataAccessException ex){
			return new ModelAndView("reservation/pageNotFound");
		} 	
		modelView = new ModelAndView("reservation/updateReservationDataForm");
		modelView.addObject("reservation", reservation);
		return modelView;
	}

	// update view Reservation page to success
	@RequestMapping(value = "/reservation/updateReservationSuccess", method = RequestMethod.POST)
	public ModelAndView updateReservationDetail(@Valid Reservation reservation,
			BindingResult result) {
		ModelAndView modelView;
		Reservation reservation1 = reservationService
				.updateReservation(reservation);
		modelView = new ModelAndView("reservation/updateReservationSuccess");
		modelView.addObject("reservationID", reservation1.getReservationID());
		return modelView;
	}

}
