package com.spring.movieTicketManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.movieTicketManagement.entity.TicketInfo;

public interface TicketInfoRepository extends JpaRepository<TicketInfo, String>{

}
