package com.book_my_show.Book.My.Show.controller;

import com.book_my_show.Book.My.Show.models.Ticket;
import com.book_my_show.Book.My.Show.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;


    @PostMapping("/buyticket")
    public ResponseEntity buyTicket(@RequestParam String email, @RequestParam UUID showId){
        Ticket ticket = ticketService.buyTicket(email, showId);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }
}
