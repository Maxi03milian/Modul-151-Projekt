package ch.ms.airline.repo;

import ch.ms.airline.entity.Pilot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotRepository extends CrudRepository<Pilot, String> {
}
