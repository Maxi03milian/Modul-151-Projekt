package ch.ms.airline.repo;

import ch.ms.airline.entity.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, String> {
}
