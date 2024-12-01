package com.example.railway_ticket_backend.entity.ticket;

import com.example.railway_ticket_backend.entity.seat.Seat;
import com.example.railway_ticket_backend.entity.trip.Trip;
import com.example.railway_ticket_backend.entity.user.User;
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
    private User user;

    @ManyToOne
    private Trip trip;

    @ManyToOne
    private Seat seat;

    @Column(nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;
}
