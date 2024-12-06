package com.example.railway_ticket_backend.controller;

import com.example.railway_ticket_backend.service.station.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/station")
@RequiredArgsConstructor
public class StationController {

    private final StationService stationService;

    @GetMapping
    public HttpEntity<?> handleGetStations(@RequestParam String stationName) {
        return stationService.handleGetStations(stationName);
    }
}
