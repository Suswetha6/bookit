package org.abhinavgpt.bookit.dtos;

import org.abhinavgpt.bookit.modals.data.Genre;

import java.util.List;

public record MovieDTO(String name, String description, List<Genre> genre, int durationInMinutes, String director, String producer, String releaseDate) {
}
