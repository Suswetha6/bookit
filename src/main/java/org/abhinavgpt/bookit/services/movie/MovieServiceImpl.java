package org.abhinavgpt.bookit.services.movie;

import org.abhinavgpt.bookit.exceptions.MovieNotFoundException;
import org.abhinavgpt.bookit.modals.Movie;
import org.abhinavgpt.bookit.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl {
    private MovieRepository movieRepository;
    MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    private final List<Movie> movies = new ArrayList<>();
    private Long nextId = 1L;

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(Long id) throws MovieNotFoundException {
//        for (Movie m : movies) {
//            if (m.getId().equals(id)) {
//                return m;
//            }
//        }
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isEmpty()){
            throw new MovieNotFoundException("Movie not found");
        }
        return optionalMovie.get();
    }

    public Movie createMovie(Movie movie) {
        movie.setId(nextId++);
        movies.add(movie);
        return movie;
    }

    public Movie updateMovie(Long id, Movie movieDetails) {
        for (Movie m : movies) {
            if (m.getId().equals(id)) {
                m.setTitle(movieDetails.getTitle());
                m.setDirector(movieDetails.getDirector());
                m.setGenre(movieDetails.getGenre());
                m.setRuntime(movieDetails.getRuntime());
                m.setReleaseDate(movieDetails.getReleaseDate());
                return m;
            }
        }
        return null;
    }

    public void deleteMovie(Long id) {
        movies.removeIf(m -> m.getId().equals(id));
    }
}
