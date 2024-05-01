package org.abhinavgpt.bookit.services.movie;

import org.abhinavgpt.bookit.exceptions.MovieNotFoundException;
import org.abhinavgpt.bookit.modals.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Override
    public List<Movie> getAllMovies() {
        return List.of();
    }

    @Override
    public Movie getMovieById(Long id) throws MovieNotFoundException {
        return null;
    }

    @Override
    public Movie createMovie(Movie movie) {
        return null;
    }

    @Override
    public Movie updateMovie(Long id, Movie movieDetails) {
        return null;
    }

    @Override
    public void deleteMovie(Long id) {

    }
}
