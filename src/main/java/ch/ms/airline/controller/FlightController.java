package ch.ms.airline.controller;

import ch.ms.airline.entity.Flight;
import ch.ms.airline.service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public Iterable<Flight> getFlights() {
        return flightService.findAll();
    }

    @PostMapping("/flights")
    public void createFlight(@RequestBody Flight flight) {
        flightService.create(flight);
    }
}
