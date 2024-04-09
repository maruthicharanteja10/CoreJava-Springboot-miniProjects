package com.spring.movieTicketManagement.exception;

public class InsufficentBalanceError extends RuntimeException {
	public InsufficentBalanceError(String message) {
		super(message);
	}
}
