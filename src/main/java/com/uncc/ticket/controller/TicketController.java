package com.uncc.ticket.controller;

import com.uncc.ticket.model.UsersEntity;
import org.springframework.validation.BindingResult;
import com.uncc.ticket.model.TicketEntity;
import com.uncc.ticket.service.TicketService;
import com.uncc.ticket.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class TicketController {

    private TicketService ticketService;

    private final UsersService usersService;

    @Autowired
    public TicketController(TicketService ticketService, UsersService usersService) {
        this.ticketService = ticketService;
        this.usersService = usersService;
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String getTickets(Model model, Principal principal) {
        UsersEntity user = usersService.findByEmail(principal.getName());
            model.addAttribute("tickets", ticketService.getAllTicketsByUser(user));
            return "tickets/tickets";
    }

    @RequestMapping(value = "/tickets/storeTickets", method = RequestMethod.GET)
    public String showStoreTicket(Model model) {
        model.addAttribute("ticket", new TicketEntity());
        return "tickets/storeTicket";
    }

    @RequestMapping(value = "/tickets/storeTickets", method = RequestMethod.POST)
    public String storeStoreTicket(Model model,@ModelAttribute(name = "ticket") @Valid TicketEntity ticket, BindingResult bindingResult,Principal principal) {
        if (bindingResult.hasErrors()) {
            return "tickets/storeTicket";
        };
        ticket.setUsers(usersService.findByEmail(principal.getName()));
        ticketService.storeTicket(ticket);
        return "redirect:/";
    }

    @RequestMapping(value = "/tickets/edit/{id}", method = RequestMethod.GET)
    public String editTicket(Model model,@PathVariable("id") Long id) {
        // Code here
        return "redirect:/"; //Remove this line
    }

    @RequestMapping(value = "/tickets/delete/{id}", method = RequestMethod.GET)
    public String deleteTicket(@PathVariable("id") Long id) {
        // Code here
        return "redirect:/";
    }

}
