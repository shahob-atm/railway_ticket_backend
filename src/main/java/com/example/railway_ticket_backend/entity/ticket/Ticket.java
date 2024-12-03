package com.example.railway_ticket_backend.entity.ticket;

import com.example.railway_ticket_backend.entity.passenger.Passenger;
import com.example.railway_ticket_backend.entity.trip.Trip;
import com.example.railway_ticket_backend.entity.tripSeat.TripSeat;
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
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Trip trip;

    @ManyToOne
    private TripSeat tripSeat;

    @Column(nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;
}
