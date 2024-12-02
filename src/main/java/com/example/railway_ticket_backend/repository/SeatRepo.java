package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat, Long> {
}
