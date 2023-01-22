package ch.ms.airline.service;

import ch.ms.airline.entity.Flight;
import ch.ms.airline.repo.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void deleteAll() {
        flightRepository.deleteAll();
    }

    public void deleteById(String id) {
        flightRepository.deleteById(id);
    }

    public void save(ch.ms.airline.entity.Flight flight) {
        flightRepository.save(flight);
    }

    public Flight findById(String id) {
        return flightRepository.findById(id).get();
    }

    public boolean existsById(String id) {
        return flightRepository.existsById(id);
    }

    public long count() {
        return flightRepository.count();
    }

    public void delete(String id) {
        flightRepository.deleteById(id);
    }

    public Iterable findAll() {
        return flightRepository.findAll();
    }
}
