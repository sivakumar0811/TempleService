package com.tutasi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
	public class SponsorNotFoundException extends RuntimeException {
	    public SponsorNotFoundException(String message) {
	        super(message);
	    }
	}

