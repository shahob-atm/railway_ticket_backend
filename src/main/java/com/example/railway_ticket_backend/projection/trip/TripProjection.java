package com.example.railway_ticket_backend.projection.trip;

import com.example.railway_ticket_backend.projection.coach.CoachTypeAndCountProjection;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.List;

public interface TripProjection {
    Long getTripId();
    String getStatus();
    String getDuration();
    LocalDate getArrivalDate();
    LocalDate getDepartureDate();
    String getRouteName();
    String getDepartureTime();
    String getArrivalTime();
    String getStartCity();
    String getEndCity();
    String getTrainName();
    String getTrainType();
    String getNumber();
    Integer getCapacity();
    Long getTrainId();
    @Value("#{@coachRepo.getCoachTypeAndCountProjection(target.tripId)}")
    List<CoachTypeAndCountProjection> getCoachTypes();
}
