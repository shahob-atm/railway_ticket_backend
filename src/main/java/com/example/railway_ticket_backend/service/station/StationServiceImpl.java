package com.example.railway_ticket_backend.service.station;

import com.example.railway_ticket_backend.entity.station.Station;
import com.example.railway_ticket_backend.projection.station.StationProjection;
import com.example.railway_ticket_backend.repository.StationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {

    private final StationRepo stationRepo;

    @Override
    public HttpEntity<?> handleGetStations(String stationName) {

        if (stationName == null || stationName.isEmpty()) {
            Station station = stationRepo.findByCity("Toshkent").orElseThrow();
            List<StationProjection> stationProjections = stationRepo.getStationProjection(station.getId());
            return ResponseEntity.ok(stationProjections);
        }

        Station station = stationRepo.findByCity(stationName).orElseThrow();
        List<StationProjection> stationProjectionList = stationRepo.getStationProjection(station.getId());
        return ResponseEntity.ok(stationProjectionList);
    }
}
