package ch.ms.airline.repo;

import ch.ms.airline.entity.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, String> {
}
