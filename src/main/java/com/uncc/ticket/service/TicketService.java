package com.uncc.ticket.service;

import com.uncc.ticket.model.TicketEntity;
import com.uncc.ticket.model.UsersEntity;
import com.uncc.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository=ticketRepository;
    }

    @Transactional
    public TicketEntity storeTicket(TicketEntity tickets){
        return ticketRepository.save(tickets);
    }

    public List<TicketEntity> getAllTickets(){
        return ticketRepository.findAll();
    }

    public List<TicketEntity> getAllTicketsByUser(UsersEntity user){
        return ticketRepository.findAllByUsers(user);
    }

    public TicketEntity findById(Long id) {
        return ticketRepository.getOne(id);
    }

    @Transactional
    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }
}
