package com.spring.movieTicketManagement.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.movieTicketManagement.dto.MovieTicketAcknowledgment;
import com.spring.movieTicketManagement.dto.MovieTicketRequest;
import com.spring.movieTicketManagement.entity.PaymentInfo;
import com.spring.movieTicketManagement.entity.TicketInfo;
import com.spring.movieTicketManagement.repository.PaymentinfoRepository;
import com.spring.movieTicketManagement.repository.TicketInfoRepository;
import com.spring.movieTicketManagement.utility.ValidatepaymentInfo;

import jakarta.transaction.Transactional;

@Service
public class MovieTicketService {
	@Autowired
	TicketInfoRepository ticketInfoRepository;
	@Autowired
	PaymentinfoRepository paymentinfoRepository;

	@Transactional
	public MovieTicketAcknowledgment bookMovieTicket(MovieTicketRequest request) {
		TicketInfo ticketInfo = request.getTicketInfo();
		ticketInfo = ticketInfoRepository.save(ticketInfo);

		PaymentInfo paymentInfo = request.getPaymentInfo();
		ValidatepaymentInfo.validateCreditLimit(paymentInfo.getAccountno(), ticketInfo.getTicketprice());

		paymentInfo.setTicketid(ticketInfo.getId());
		paymentInfo.setAmount(ticketInfo.getTicketprice());

		paymentinfoRepository.save(paymentInfo);

		return new MovieTicketAcknowledgment("SUCCESSS", ticketInfo.getTicketprice(),
				UUID.randomUUID().toString().split("-")[0], ticketInfo);
	}
}
