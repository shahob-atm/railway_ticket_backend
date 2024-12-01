package com.example.railway_ticket_backend.entity.routeStop;

import com.example.railway_ticket_backend.entity.route.Route;
import com.example.railway_ticket_backend.entity.station.Station;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouteStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Route route;

    @ManyToOne
    private Station station;

    @Column(nullable = false)
    private Integer stopOrder;

    private LocalTime arrivalTime;

    private LocalTime departureTime;
}
