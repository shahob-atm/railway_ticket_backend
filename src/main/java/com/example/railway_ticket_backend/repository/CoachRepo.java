package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.coach.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepo extends JpaRepository<Coach, Long> {
}
