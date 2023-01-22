package ch.ms.airline.repo;

import ch.ms.airline.entity.Pilot;
import org.springframework.data.repository.CrudRepository;

public interface PilotRepository extends CrudRepository<Pilot, String> {
}
