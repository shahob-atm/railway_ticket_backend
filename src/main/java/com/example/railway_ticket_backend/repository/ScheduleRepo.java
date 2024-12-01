package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule, Long> {
}
