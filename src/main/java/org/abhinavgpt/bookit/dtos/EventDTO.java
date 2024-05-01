package org.abhinavgpt.bookit.dtos;

public record EventDTO(String startTime, String endTime, long movieId, long hallId, long price) {
}