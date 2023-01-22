package ch.ms.airline.controller;

import ch.ms.airline.entity.Airport;
import ch.ms.airline.service.AircraftService;
import ch.ms.airline.service.AirportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController {

    AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/airports")
    public Iterable<Airport> getAirports() {
        return airportService.findAll();
    }
}
