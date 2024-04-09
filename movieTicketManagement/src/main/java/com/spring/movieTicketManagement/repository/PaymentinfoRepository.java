package com.spring.movieTicketManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.movieTicketManagement.entity.PaymentInfo;

public interface PaymentinfoRepository extends JpaRepository<PaymentInfo, Long>{

}
