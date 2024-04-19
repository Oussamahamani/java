package edu.bhcc.fitnessTracker;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface fitnessTrackerRepository extends CrudRepository<Fitness,Long> {

    Fitness findById(long id);

    List<Fitness> findByProject(String project);
}
