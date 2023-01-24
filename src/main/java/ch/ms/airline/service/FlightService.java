package ch.ms.airline.service;

import ch.ms.airline.entity.Aircraft;
import ch.ms.airline.entity.Airport;
import ch.ms.airline.entity.Flight;
import ch.ms.airline.model.request.FlightRequest;
import ch.ms.airline.repo.AircraftRepository;
import ch.ms.airline.repo.AirportRepository;
import ch.ms.airline.repo.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    FlightRepository flightRepository;
    AirportRepository airportRepository;
    AircraftRepository aircraftRepository;


    public FlightService(FlightRepository flightRepository, AirportRepository airportRepository, AircraftRepository aircraftRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.aircraftRepository = aircraftRepository;
    }

    public Iterable findAll() {
        return flightRepository.findAll();
    }

    public void update(String id,  FlightRequest flight) {
        Airport departureAirport = airportRepository.findById(flight.getDepartureAirportID()).get();
        Airport arrivalAirport = airportRepository.findById(flight.getArrivalAirportID()).get();
        Aircraft aircraft = aircraftRepository.findById(flight.getAircraftID()).get();

        Flight flightToUpdate = flightRepository.findById(id).get();
        flightToUpdate.setFlightNumber(flight.getFlightNumber());
        flightToUpdate.setDepartureAirport(departureAirport);
        flightToUpdate.setArrivalAirport(arrivalAirport);
        flightToUpdate.setDepartureTime(flight.getDepartureTime());
        flightToUpdate.setArrivalTime(flight.getArrivalTime());
        flightToUpdate.setAircraft(aircraft);
        flightRepository.save(flightToUpdate);
    }

    public void create(FlightRequest flight) {
        Airport departureAirport = airportRepository.findById(flight.getDepartureAirportID()).get();
        Airport arrivalAirport = airportRepository.findById(flight.getArrivalAirportID()).get();
        Aircraft aircraft = aircraftRepository.findById(flight.getAircraftID()).get();
        Flight newFlight = new Flight(flight, departureAirport, arrivalAirport, aircraft);
        flightRepository.save(newFlight);
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
