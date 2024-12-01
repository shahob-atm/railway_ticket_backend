package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.station.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepo extends JpaRepository<Station, Long> {
}
