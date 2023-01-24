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

    public Iterable findAll() {
        return flightRepository.findAll();
    }

    public void update(String id,  Flight flight) {
        Flight flightToUpdate = flightRepository.findById(id).get();
        flightToUpdate.setFlightNumber(flight.getFlightNumber());
        flightToUpdate.setDepartureAirport(flight.getDepartureAirport());
        flightToUpdate.setArrivalAirport(flight.getArrivalAirport());
        flightToUpdate.setDepartureTime(flight.getDepartureTime());
        flightToUpdate.setArrivalTime(flight.getArrivalTime());
        flightToUpdate.setAircraft(flight.getAircraft());
        flightRepository.save(flightToUpdate);
    }

    public void create(Flight flight) {
        flightRepository.save(flight);
    }

    public void delete(String id) {
        flightRepository.deleteById(id);
    }

    public void deleteAll() {
        flightRepository.deleteAll();
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

}
