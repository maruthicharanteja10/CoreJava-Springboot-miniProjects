package com.spring.movieTicketManagement.dto;

import com.spring.movieTicketManagement.entity.TicketInfo;

public class MovieTicketAcknowledgment {
	private String status;
	private double totalfare;
	private String prno;
	private TicketInfo ticketInfo;

	public MovieTicketAcknowledgment(String status, double totalfare, String prno, TicketInfo ticketInfo) {
		super();
		this.status = status;
		this.totalfare = totalfare;
		this.prno = prno;
		this.ticketInfo = ticketInfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalfare() {
		return totalfare;
	}

	public void setTotalfare(double totalfare) {
		this.totalfare = totalfare;
	}

	public String getPrno() {
		return prno;
	}

	public void setPrno(String prno) {
		this.prno = prno;
	}

	public TicketInfo getTicketInfo() {
		return ticketInfo;
	}

	public void setTicketInfo(TicketInfo ticketInfo) {
		this.ticketInfo = ticketInfo;
	}

	@Override
	public String toString() {
		return "MovieTicketAcknowledgment [status=" + status + ", totalfare=" + totalfare + ", prno=" + prno
				+ ", ticketInfo=" + ticketInfo + "]";
	}

}
