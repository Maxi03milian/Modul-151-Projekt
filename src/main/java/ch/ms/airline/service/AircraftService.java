package ch.ms.airline.service;

import ch.ms.airline.entity.Aircraft;
import ch.ms.airline.entity.Pilot;
import ch.ms.airline.model.request.AircraftRequest;
import ch.ms.airline.repo.AircraftRepository;
import ch.ms.airline.repo.PilotRepository;
import org.springframework.stereotype.Service;

@Service
public class AircraftService {

    AircraftRepository aircraftRepository;
    PilotRepository pilotRepository;

    public AircraftService(AircraftRepository aircraftRepository, PilotRepository pilotRepository) {
        this.aircraftRepository = aircraftRepository;
        this.pilotRepository = pilotRepository;
    }

    public Iterable<Aircraft> findAll() {
        return aircraftRepository.findAll();
    }
    public void create(AircraftRequest aircraft) {
        Pilot pilot = pilotRepository.findById(aircraft.getPilotID()).get();
        if (pilot.getAircraft() != null) {
            throw new IllegalArgumentException("Pilot is already assigned to an aircraft");
        }
        Aircraft newAircraft = new Aircraft(aircraft, pilot);
        aircraftRepository.save(newAircraft);
    }

    public void update(String id, AircraftRequest aircraft) {
        Pilot pilot = pilotRepository.findById(aircraft.getPilotID()).get();
        if (pilot.getAircraft() != null && !pilot.getAircraft().getId().equals(id)) {
            throw new IllegalArgumentException("Pilot is already assigned to an aircraft");
        }
        Aircraft aircraftToUpdate = aircraftRepository.findById(id).get();
        aircraftToUpdate.setName(aircraft.getName());
        aircraftToUpdate.setManufacturer(aircraft.getManufacturer());
        aircraftToUpdate.setYearManufactured(aircraft.getYearManufactured());
        aircraftToUpdate.setSeatCapacity(aircraft.getSeatCapacity());
        aircraftToUpdate.setPilot(pilot);
        aircraftRepository.save(aircraftToUpdate);
    }

    public void delete(String id) {
        aircraftRepository.deleteById(id);
    }

    public Aircraft getAircraft(String id) {
        return aircraftRepository.findById(id).get();
    }

}
