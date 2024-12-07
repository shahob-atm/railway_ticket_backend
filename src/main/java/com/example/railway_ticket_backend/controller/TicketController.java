package com.example.railway_ticket_backend.controller;

import com.example.railway_ticket_backend.dto.ticket.TicketDto;
import com.example.railway_ticket_backend.service.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public HttpEntity<?> handlePostTicket(@RequestBody @Validated TicketDto ticketDto) {
        return ticketService.handlePostTicket(ticketDto);
    }

    @GetMapping
    public HttpEntity<?> handleGetTicket(@RequestParam String ticketNumber) {
        return ticketService.handleGetTicket(ticketNumber);
    }
}
