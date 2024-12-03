package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
}
