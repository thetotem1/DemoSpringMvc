package be.storm.demo_spring_mvc.pl.controllers;

import be.storm.demo_spring_mvc.dl.entities.Director;
import be.storm.demo_spring_mvc.dl.entities.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MovieController {

    Director director1 = new Director(1L, "Jojo");
    Movie movie1 = new Movie(1L, "Jurrassic Parc", director1);
    Movie movie2 = new Movie(2L, "Jurrassic Parc2", director1);

    private List<Movie> movies = List.of(movie1, movie2);

    @GetMapping("/movie/{id}")
    public String movie(
            @PathVariable
            Long id,
            Model model
    ) {
        for (Movie movie : movies) {
            if (movie.getId().equals(id)) {
                model.addAttribute("movie", movie);
                return "movie";
            }
        }
        return "error";
    }
}
