package com.spring.movieTicketManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movieTicketManagement.dto.MovieTicketAcknowledgment;
import com.spring.movieTicketManagement.dto.MovieTicketRequest;
import com.spring.movieTicketManagement.service.MovieTicketService;

@RestController
public class MovieTicketController {
	@Autowired
	MovieTicketService service;
	
	@PostMapping("/bookMovieTicket")
	public MovieTicketAcknowledgment bookTicket(@RequestBody MovieTicketRequest request) {
		return service.bookMovieTicket(request);
	}
}
