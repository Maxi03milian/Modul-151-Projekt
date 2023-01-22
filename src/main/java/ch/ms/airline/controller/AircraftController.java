package ch.ms.airline.controller;

import ch.ms.airline.entity.Aircraft;
import ch.ms.airline.service.AircraftService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AircraftController {

    AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping("/aircrafts")
    public Iterable<Aircraft> getAircrafts() {
        return aircraftService.getAllAircrafts();
    }

    @PostMapping("/aircrafts")
    public void createAircraft(@RequestBody Aircraft aircraft) {
        aircraftService.createAircraft(aircraft);
    }



}
