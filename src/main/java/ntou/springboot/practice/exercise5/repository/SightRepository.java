package ntou.springboot.practice.exercise5.repository;

import ntou.springboot.practice.exercise5.entity.Sight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SightRepository extends MongoRepository<Sight, String> {

    @Query("{'zone' : ?0 }")
    List<Sight> findByZone(String pointName);
}
