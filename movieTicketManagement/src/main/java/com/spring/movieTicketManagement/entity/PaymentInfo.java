package com.spring.movieTicketManagement.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PaymentInfo {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name="uuid2",strategy = "org.hibernate.id.UUIDGenerator")
	private String paymentId;
	private String accountno;
	private double amount;
	private String cardtype;
	private double ticketid;

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public double getTicketid() {
		return ticketid;
	}

	public void setTicketid(double ticketid) {
		this.ticketid = ticketid;
	}

	@Override
	public String toString() {
		return "PaymentInfo [paymentId=" + paymentId + ", accountno=" + accountno + ", amount=" + amount + ", cardtype="
				+ cardtype + ", ticketid=" + ticketid + "]";
	}

}
