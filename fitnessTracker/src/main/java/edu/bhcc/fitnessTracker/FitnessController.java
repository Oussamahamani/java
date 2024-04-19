package edu.bhcc.fitnessTracker;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FitnessController {


    private  fitnessTrackerRepository repo;
    /**
     * Create Fitness Controller.
     */
    public FitnessController(fitnessTrackerRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String index(Model model){
//        List<Fitness> fitnessList = getAllTracks();
//        model.addAttribute()
        return "list";
    }

    private List<Fitness> getAllTracks() {
        Iterable<Fitness> trackIter = repo.findAll();
        List<Fitness> trackList = new ArrayList<>();
        for (Fitness currentTodo : trackIter) {
            trackList.add(currentTodo);
        }
        return trackList;
    }
}
