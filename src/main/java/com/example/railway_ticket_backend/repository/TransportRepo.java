package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.Transport.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepo extends JpaRepository<Transport, Long> {
}
