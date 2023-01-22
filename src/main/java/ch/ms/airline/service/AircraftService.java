package ch.ms.airline.service;

import ch.ms.airline.entity.Aircraft;
import ch.ms.airline.repo.AircraftRepository;
import org.springframework.stereotype.Service;

@Service
public class AircraftService {

    AircraftRepository aircraftRepository;

    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public void createAircraft(Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(String id) {
        aircraftRepository.deleteById(id);
    }

    public Iterable<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }

    public Aircraft getAircraft(String id) {
        return aircraftRepository.findById(id).get();
    }

    public void updateAircraft(Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }
}
