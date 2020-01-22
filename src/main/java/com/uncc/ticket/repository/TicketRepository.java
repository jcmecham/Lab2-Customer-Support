package com.uncc.ticket.repository;

import com.uncc.ticket.model.TicketEntity;
import com.uncc.ticket.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {

    List<TicketEntity> findAllByUsers(UsersEntity user);

}
