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

    public void save(Airport airport) {
        airportRepository.save(airport);
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

    public void deleteAll() {
        airportRepository.deleteAll();
    }


    public void delete(String id) {
        airportRepository.deleteById(id);
    }

    public void deleteById(String id) {
        airportRepository.deleteById(id);
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
