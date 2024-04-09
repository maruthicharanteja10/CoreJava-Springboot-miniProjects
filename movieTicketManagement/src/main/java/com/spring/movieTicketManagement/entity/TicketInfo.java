package com.spring.movieTicketManagement.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TicketInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String email;
	private String moviename;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD-MM-YYYY")
	private Date moviedate;
	private String movietime;
	private double ticketprice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public Date getMoviedate() {
		return moviedate;
	}

	public void setMoviedate(Date moviedate) {
		this.moviedate = moviedate;
	}

	public String getMovietime() {
		return movietime;
	}

	public void setMovietime(String movietime) {
		this.movietime = movietime;
	}

	public double getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}

	@Override
	public String toString() {
		return "TicketInfo [id=" + id + ", username=" + username + ", email=" + email + ", moviename=" + moviename
				+ ", moviedate=" + moviedate + ", movietime=" + movietime + ", ticketprice=" + ticketprice + "]";
	}

}
