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
        Aircraft newAircraft = new Aircraft(aircraft);
        aircraftRepository.save(newAircraft);
    }

    public void update(String id, Aircraft aircraft) {
        Aircraft aircraftToUpdate = aircraftRepository.findById(id).get();
        aircraftToUpdate.setName(aircraft.getName());
        aircraftToUpdate.setManufacturer(aircraft.getManufacturer());
        aircraftToUpdate.setYearManufactured(aircraft.getYearManufactured());
        aircraftToUpdate.setSeatCapacity(aircraft.getSeatCapacity());
        aircraftToUpdate.setFlights(aircraft.getFlights());
        aircraftRepository.save(aircraftToUpdate);
    }

    public void delete(String id) {
        aircraftRepository.deleteById(id);
    }

    public Iterable<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }

    public Aircraft getAircraft(String id) {
        return aircraftRepository.findById(id).get();
    }

}
