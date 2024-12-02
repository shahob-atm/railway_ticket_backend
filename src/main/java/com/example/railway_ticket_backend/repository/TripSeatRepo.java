package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.tripSeat.TripSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripSeatRepo extends JpaRepository<TripSeat, Long> {
}
