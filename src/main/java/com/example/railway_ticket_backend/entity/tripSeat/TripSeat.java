package com.example.railway_ticket_backend.entity.tripSeat;

import com.example.railway_ticket_backend.entity.seat.Seat;
import com.example.railway_ticket_backend.entity.trip.Trip;
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
public class TripSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Trip trip;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private TripSeatStatus status;
}
