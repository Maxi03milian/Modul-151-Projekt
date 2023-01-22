package ch.ms.airline.service;

import ch.ms.airline.entity.Pilot;
import ch.ms.airline.repo.PilotRepository;
import org.springframework.stereotype.Service;

@Service
public class PilotService {

    PilotRepository pilotRepository;

    public PilotService(PilotRepository pilotRepository) {
        this.pilotRepository = pilotRepository;
    }

    public void save(Pilot pilot) {
        pilotRepository.save(pilot);
    }

    public Pilot findById(String id) {
        return pilotRepository.findById(id).get();
    }

    public boolean existsById(String id) {
        return pilotRepository.existsById(id);
    }

    public long count() {
        return pilotRepository.count();
    }

    public void delete(String id) {
        pilotRepository.deleteById(id);
    }

    public Iterable findAll() {
        return pilotRepository.findAll();
    }

    public void deleteAll() {
        pilotRepository.deleteAll();
    }

    public void deleteById(String id) {
        pilotRepository.deleteById(id);
    }
}
