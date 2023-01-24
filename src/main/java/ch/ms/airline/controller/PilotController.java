package ch.ms.airline.controller;

import ch.ms.airline.entity.Pilot;
import ch.ms.airline.service.PilotService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PilotController {

    PilotService pilotService;

    public PilotController(PilotService pilotService) {
        this.pilotService = pilotService;
    }

    @GetMapping("/pilots")
    public Iterable<Pilot> getPilots() {
        return pilotService.findAll();
    }

    @PostMapping("/pilots")
    public void createPilot(@RequestBody Pilot pilot) {
        pilotService.create(pilot);
    }

    @PutMapping("/pilots")
    public void editPilot(@RequestParam String pilotID, @RequestBody Pilot pilot) {
        pilotService.update(pilotID, pilot);
    }

    @DeleteMapping("/pilots")
    public void delete(@RequestParam String pilotID) {
        pilotService.delete(pilotID);
    }



}
