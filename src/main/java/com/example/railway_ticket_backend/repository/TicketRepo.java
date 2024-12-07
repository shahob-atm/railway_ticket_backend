package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByNumber(String ticketNumber);
}
