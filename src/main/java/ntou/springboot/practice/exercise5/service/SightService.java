package ntou.springboot.practice.exercise5.service;

import ntou.springboot.practice.exercise5.entity.Sight;
import ntou.springboot.practice.exercise5.repository.SightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightService {
    private final SightRepository sightRepository;

    public SightService(SightRepository sightRepository) {
        this.sightRepository = sightRepository;
    }

    public Sight insertSight(Sight sight) {
        return sightRepository.insert(sight);
    }

    public List<Sight> findByZone(String sightName) {
        List<Sight> sights = sightRepository.findByZone(sightName);
        return sights;
    }
}
