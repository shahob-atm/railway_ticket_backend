package com.example.railway_ticket_backend.entity.trip;

import com.example.railway_ticket_backend.entity.schedule.Schedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Schedule schedule;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    @Enumerated(EnumType.STRING)
    private TripStatus status;
}
