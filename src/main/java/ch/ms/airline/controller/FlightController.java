package ch.ms.airline.controller;

import ch.ms.airline.entity.Flight;
import ch.ms.airline.model.request.FlightRequest;
import ch.ms.airline.service.FlightService;
import org.springframework.web.bind.annotation.*;

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
    public void createFlight(@RequestBody FlightRequest flight) {
        flightService.create(flight);
    }
    @PutMapping("/flights")
    public void editFlight(@RequestParam String flightID, @RequestBody Flight flight) {
        flightService.update(flightID, flight);
    }

    @DeleteMapping("/flights")
    public void delete(@RequestParam String flightID) {
        flightService.delete(flightID);
    }
}
