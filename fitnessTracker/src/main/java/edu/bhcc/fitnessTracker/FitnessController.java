package edu.bhcc.fitnessTracker;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@Controller
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
        TrackListWithTotal tracks = new TrackListWithTotal(getAllTracks());
        model.addAttribute("tracks",tracks);
        return "index";
    }

    @GetMapping("/add_track")
    public String addTodo(String route, String date, double miles,Model model) {
        Fitness track = new Fitness(route,date,miles);
        repo.save(track);
        TrackListWithTotal tracks = new TrackListWithTotal(getAllTracks());
        model.addAttribute("toast", "New record added:  " + track.getRoute() + ".");
        model.addAttribute("tracks",tracks);
        return "index";
    }

    @GetMapping("/delete_todo")
    public String deleteTodo(Integer id, Model model) {
        Fitness track = this.repo.findById(id);
        if (track != null) {
            model.addAttribute("toast", "Deleted Record:  " + track.getRoute() + ".");
            this.repo.delete(track);
        } else {
            model.addAttribute("toast", "Could not Record: " + id + ".");
        }

        TrackListWithTotal tracks = new TrackListWithTotal(getAllTracks());
        model.addAttribute("tracks", tracks);
        return "index";
    }
    private List<Fitness> getAllTracks() {
        Iterable<Fitness> trackIter = repo.findAll();
        List<Fitness> trackList = new ArrayList<>();
        for (Fitness currentTrack : trackIter) {
            trackList.add(currentTrack);
        }
        return trackList;
    }
}
