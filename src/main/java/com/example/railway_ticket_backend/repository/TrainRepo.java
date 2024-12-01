package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.train.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepo extends JpaRepository<Train, Long> {
}
