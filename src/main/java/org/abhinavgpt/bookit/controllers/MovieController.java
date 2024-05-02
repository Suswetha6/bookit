package org.abhinavgpt.bookit.controllers;

import org.abhinavgpt.bookit.dtos.MovieDTO;
import org.abhinavgpt.bookit.exceptions.MovieNotFoundException;
import org.abhinavgpt.bookit.modals.Movie;
import org.abhinavgpt.bookit.services.movie.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieServiceImpl movieService;

    @Autowired
    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @GetMapping("")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) throws MovieNotFoundException {
        return movieService.getMovieById(id);
    }

    @PostMapping("")
    public Movie createMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.createMovie(movieDTO);
    }

    @PutMapping("")
    public Movie updateMovie(@RequestBody Movie movieDetails) {
        return movieService.updateMovie(movieDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

}
