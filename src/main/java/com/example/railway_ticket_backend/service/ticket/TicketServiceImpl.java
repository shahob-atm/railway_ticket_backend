package com.example.railway_ticket_backend.service.ticket;

import com.example.railway_ticket_backend.dto.ticket.TicketDto;
import com.example.railway_ticket_backend.entity.passenger.Passenger;
import com.example.railway_ticket_backend.entity.ticket.Ticket;
import com.example.railway_ticket_backend.entity.ticket.TicketStatus;
import com.example.railway_ticket_backend.entity.trip.Trip;
import com.example.railway_ticket_backend.entity.tripSeat.TripSeat;
import com.example.railway_ticket_backend.entity.tripSeat.TripSeatStatus;
import com.example.railway_ticket_backend.repository.PassengerRepo;
import com.example.railway_ticket_backend.repository.TicketRepo;
import com.example.railway_ticket_backend.repository.TripRepo;
import com.example.railway_ticket_backend.repository.TripSeatRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepo ticketRepo;
    private final PassengerRepo passengerRepo;
    private final TripRepo tripRepo;
    private final TripSeatRepo tripSeatRepo;

    @Override
    @Transactional
    public HttpEntity<?> handlePostTicket(TicketDto ticketDto) {

        Trip trip = tripRepo.findById(ticketDto.tripId()).orElseThrow();
        TripSeat tripSeat = tripSeatRepo.findById(ticketDto.tripSeatId()).orElseThrow();

        Passenger passenger = Passenger.builder()
                .firstName(ticketDto.firstName())
                .lastName(ticketDto.lastName())
                .birthDate(ticketDto.birthDate())
                .docType(ticketDto.docType())
                .documentNumber(ticketDto.documentNumber())
                .documentCountry(ticketDto.documentCountry()).build();

        passengerRepo.save(passenger);

        String generateTicket = new TicketGenerator().handleGenerateTicket();

        Ticket ticket = Ticket.builder()
                .number(generateTicket)
                .passenger(passenger)
                .price(Double.valueOf(ticketDto.price()))
                .tripSeat(tripSeat)
                .status(TicketStatus.PURCHASED).trip(trip).build();

        Ticket saved = ticketRepo.save(ticket);

        tripSeat.setStatus(TripSeatStatus.BOOKED);
        tripSeatRepo.save(tripSeat);

        return ResponseEntity.ok(saved);
    }

    @Override
    public HttpEntity<?> handleGetTicket(String ticketNumber) {
        Ticket ticket = ticketRepo.findByNumber(ticketNumber).orElseThrow();
        return ResponseEntity.ok(ticket);
    }
}
