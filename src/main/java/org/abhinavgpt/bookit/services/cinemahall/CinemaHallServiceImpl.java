package org.abhinavgpt.bookit.services.cinemahall;

import org.abhinavgpt.bookit.exceptions.CinemaHallNotFoundException;
import org.abhinavgpt.bookit.modals.CinemaHall;
import org.abhinavgpt.bookit.repositories.CinemaHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    private final CinemaHallRepository cinemaHallRepository;

    @Autowired
    public CinemaHallServiceImpl(CinemaHallRepository cinemaHallRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
    }

    public CinemaHall addCinemaHall(CinemaHall cinemaHall) {
        return cinemaHallRepository.save(cinemaHall);
    }

    public CinemaHall updateCinemaHall(CinemaHall updatedCinemaHall) {
        return cinemaHallRepository.save(updatedCinemaHall);

    }

    public void deleteCinemaHall(Long hallId) {
        cinemaHallRepository.deleteById(hallId);
    }

    public List<CinemaHall> getAllCinemaHalls() {
        return cinemaHallRepository.findAll();
    }

    public CinemaHall getCinemaHallById(Long hallId) throws CinemaHallNotFoundException {
        return cinemaHallRepository.findById(hallId).orElseThrow(() -> new CinemaHallNotFoundException("Cinema Hall not found."));
    }
}
