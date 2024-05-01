package org.abhinavgpt.bookit.controllers;

import org.abhinavgpt.bookit.exceptions.CinemaHallNotFoundException;
import org.abhinavgpt.bookit.modals.CinemaHall;
import org.abhinavgpt.bookit.services.cinemahall.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemaHalls")
public class CinemaHallController {

    private final CinemaHallService cinemaHallService;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService) {
        this.cinemaHallService = cinemaHallService;
    }

    @PostMapping("")
    public ResponseEntity<CinemaHall> addCinemaHall(@RequestBody CinemaHall cinemaHall) {
        CinemaHall newCinemaHall = cinemaHallService.addCinemaHall(cinemaHall);
        return ResponseEntity.ok(newCinemaHall);
    }

    @PutMapping("/{Hall_ID}")
    public ResponseEntity<CinemaHall> updateCinemaHall(@PathVariable Long Hall_ID, @RequestBody CinemaHall updatedHall) {

        CinemaHall cinemaHall = cinemaHallService.updateCinemaHall(updatedHall);
        return ResponseEntity.ok(updatedHall);
    }

    @DeleteMapping("/{hallId}")
    public ResponseEntity<String> deleteCinemaHall(@PathVariable("hallId") Long hallId) {
        cinemaHallService.deleteCinemaHall(hallId);
        return new ResponseEntity<>("Cinema Hall deleted successfully.", HttpStatus.NO_CONTENT); // 204 No Content
    }

    @GetMapping("")
    public ResponseEntity<List<CinemaHall>> getAllCinemaHalls() {
        List<CinemaHall> cinemaHalls = cinemaHallService.getAllCinemaHalls();
        return ResponseEntity.ok(cinemaHalls);
    }

    @GetMapping("/{hallId}")
    public ResponseEntity<CinemaHall> getCinemaHallById(@PathVariable("hallId") Long hallId) throws CinemaHallNotFoundException {
        CinemaHall cinemaHall = cinemaHallService.getCinemaHallById(hallId);
        return ResponseEntity.ok(cinemaHall);
    }

}
