package com.npu.hotelBooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND)
public class EmptyResultDataAccessException extends RuntimeException {
	public EmptyResultDataAccessException(String msg) {
		super (msg);
	}

}
