package ch.ms.airline.controller;

import ch.ms.airline.entity.Airport;
import ch.ms.airline.service.AircraftService;
import ch.ms.airline.service.AirportService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/airports")
    public void createAirport(@RequestBody Airport airport) {
        airportService.create(airport);
    }

    @PutMapping("/airports")
    public void editAirport(@RequestParam String airportID, @RequestBody Airport airport) {
        airportService.update(airportID, airport);
    }

    @DeleteMapping("/airports")
    public void delete(@RequestParam String airportID) {
        airportService.delete(airportID);
    }
}
