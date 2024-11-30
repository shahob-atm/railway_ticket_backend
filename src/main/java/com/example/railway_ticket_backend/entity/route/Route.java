package com.example.railway_ticket_backend.entity.route;

import com.example.railway_ticket_backend.entity.station.Station;
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
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Double distance;

    @Enumerated(EnumType.STRING)
    private RouteType routeType;

    private Boolean isActive = true;

    @ManyToOne
    private Station startStation;

    @ManyToOne
    private Station endStation;


}
