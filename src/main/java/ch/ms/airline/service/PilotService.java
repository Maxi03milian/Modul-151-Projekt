package ch.ms.airline.service;

import ch.ms.airline.entity.Airport;
import ch.ms.airline.entity.Pilot;
import ch.ms.airline.repo.AirportRepository;
import ch.ms.airline.repo.PilotRepository;
import org.springframework.stereotype.Service;

@Service
public class PilotService {

    PilotRepository pilotRepository;
    AirportRepository airportRepository;

    public PilotService(PilotRepository pilotRepository, AirportRepository airportRepository) {
        this.pilotRepository = pilotRepository;
        this.airportRepository = airportRepository;
    }

    public Iterable findAll() {
        return pilotRepository.findAll();
    }

    public void create(Pilot pilot) {
        Pilot newPilot = new Pilot(pilot);
        pilotRepository.save(newPilot);
    }

    public void update(String id, Pilot pilot) {
        Pilot pilotToUpdate = pilotRepository.findById(id).get();
        pilotToUpdate.setFirstName(pilot.getFirstName());
        pilotToUpdate.setLastName(pilot.getLastName());
        pilotRepository.save(pilotToUpdate);
    }

    public void delete(String id) {
        pilotRepository.deleteById(id);
    }

    public Pilot findById(String id) {
        return pilotRepository.findById(id).get();
    }

    public boolean existsById(String id) {
        return pilotRepository.existsById(id);
    }

    public long count() {
        return pilotRepository.count();
    }

    public void deleteAll() {
        pilotRepository.deleteAll();
    }

    public void deleteById(String id) {
        pilotRepository.deleteById(id);
    }

    public void addPilotToAirport(String pilotID, String airportID) {
        Pilot pilot = pilotRepository.findById(pilotID).get();
        Airport airport = airportRepository.findById(airportID).get();
        if (pilot == null || airport == null) {
            throw new IllegalArgumentException("Pilot or Airport not found");
        }
        airport.getPilots().add(pilot);
        pilot.getAirports().add(airport);
        pilotRepository.save(pilot);
        airportRepository.save(airport);
    }
}
