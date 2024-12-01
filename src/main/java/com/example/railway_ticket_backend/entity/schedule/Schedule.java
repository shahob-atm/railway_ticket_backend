package com.example.railway_ticket_backend.entity.schedule;

import com.example.railway_ticket_backend.entity.route.Route;
import com.example.railway_ticket_backend.entity.train.Train;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Route route;

    @ManyToOne
    private Train train;

    private String daysOfOperation;
}
