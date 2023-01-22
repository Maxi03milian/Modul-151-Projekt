package ch.ms.airline.repo;

import ch.ms.airline.entity.Aircraft;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, String> {
}
