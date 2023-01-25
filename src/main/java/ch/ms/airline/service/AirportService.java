package ch.ms.airline.service;

import ch.ms.airline.entity.Airport;
import ch.ms.airline.repo.AirportRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Iterable findAll() {
        return airportRepository.findAll();
    }

    public void create(Airport airport) {
        Airport newAirport = new Airport(airport);
        airportRepository.save(newAirport);
    }
    public void update(String id, Airport airport) {
        Airport airportToUpdate = airportRepository.findById(id).get();
        airportToUpdate.setName(airport.getName());
        airportToUpdate.setCode(airport.getCode());
        airportToUpdate.setCity(airport.getCity());
        airportToUpdate.setCountry(airport.getCountry());
        airportToUpdate.setDepartureFlights(airport.getDepartureFlights());
        airportToUpdate.setArrivalFlights(airport.getArrivalFlights());
        airportRepository.save(airportToUpdate);
    }

    public void delete(String id) {
        Airport airport = airportRepository.findById(id).get();
        if (airport.getDepartureFlights() != null || airport.getArrivalFlights() != null) {
            throw new IllegalArgumentException("Airport is assigned to a flight");
        }
        if(airport.getPilots() != null) {
            throw new IllegalArgumentException("Airport is assigned to at least one pilot");
        }
        airportRepository.deleteById(id);
    }

    public void deleteAll() {
        airportRepository.deleteAll();
    }

    public Airport findById(String id) {
        return airportRepository.findById(id).get();
    }

    public boolean existsById(String id) {
        return airportRepository.existsById(id);
    }

    public long count() {
        return airportRepository.count();
    }


}
