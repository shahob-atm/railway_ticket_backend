package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepo extends JpaRepository<Seat, Long> {

    List<Seat> findSeatsByCoachId(Long coachId);
}
