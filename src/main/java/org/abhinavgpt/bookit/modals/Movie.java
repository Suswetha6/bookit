package org.abhinavgpt.bookit.modals;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Movie {
    Long id;
    String title;
    String director;
    String genre;
    Long runtime;
    LocalDate releaseDate;

    public Movie(Long id, String title, String director, String genre, Long runtime, LocalDate releaseDate) {

        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.runtime = runtime;
        this.releaseDate = releaseDate;
    }

    public Movie() {
    }


}
