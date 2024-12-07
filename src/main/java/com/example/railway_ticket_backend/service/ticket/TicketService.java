package com.example.railway_ticket_backend.service.ticket;

import com.example.railway_ticket_backend.dto.ticket.TicketDto;
import org.springframework.http.HttpEntity;

public interface TicketService {
    HttpEntity<?> handlePostTicket(TicketDto ticketDto);

    HttpEntity<?> handleGetTicket(String ticketNumber);
}
