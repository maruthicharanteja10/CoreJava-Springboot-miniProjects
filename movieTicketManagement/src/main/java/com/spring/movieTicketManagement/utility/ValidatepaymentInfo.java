package com.spring.movieTicketManagement.utility;

import java.util.HashMap;
import java.util.Map;

import com.spring.movieTicketManagement.exception.InsufficentBalanceError;

public class ValidatepaymentInfo {
	private static Map<String, Double> paymentInfo = new HashMap<>();
	static {
		paymentInfo.put("acc1", 1000.0);
		paymentInfo.put("acc2", 500.0);
		paymentInfo.put("acc3", 2000.0);

	}

	public static boolean validateCreditLimit(String accNo, double paidAmount) {
		if (paidAmount > paymentInfo.get(accNo)) {
			throw new InsufficentBalanceError("Insufficent Balance!!!");
		} else {
			return true;
		}
	}
}
