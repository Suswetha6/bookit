package org.abhinavgpt.bookit.services.movie;

import org.abhinavgpt.bookit.dtos.MovieDTO;
import org.abhinavgpt.bookit.exceptions.MovieNotFoundException;
import org.abhinavgpt.bookit.modals.Movie;
import org.abhinavgpt.bookit.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) throws MovieNotFoundException {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie with id: " + id + " not found!"));
    }

    @Override
    public Movie createMovie(MovieDTO movieDTO) {
        System.out.println(movieDTO);
        Movie movie = new Movie(movieDTO.name(), movieDTO.description(), movieDTO.durationInMinutes(), movieDTO.director(), movieDTO.producer(), movieDTO.genre(), LocalDateTime.parse(movieDTO.releaseDate()));
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movieDetails) {
        return movieRepository.save(movieDetails);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
