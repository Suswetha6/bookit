package org.abhinavgpt.bookit.services.movie;

import org.abhinavgpt.bookit.dtos.MovieDTO;
import org.abhinavgpt.bookit.exceptions.MovieNotFoundException;
import org.abhinavgpt.bookit.modals.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(Long id) throws MovieNotFoundException;

    Movie createMovie(MovieDTO movieDTO);

    Movie updateMovie(Movie movieDetails);

    void deleteMovie(Long id);
}
