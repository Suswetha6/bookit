package org.abhinavgpt.bookit.services.cinemahall;

import org.abhinavgpt.bookit.exceptions.CinemaHallNotFoundException;
import org.abhinavgpt.bookit.modals.CinemaHall;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CinemaHallService {

    CinemaHall addCinemaHall(CinemaHall cinemaHall);

    CinemaHall updateCinemaHall(CinemaHall updatedCinemaHall);

    void deleteCinemaHall(Long hallId);

    List<CinemaHall> getAllCinemaHalls();

    CinemaHall getCinemaHallById(Long hallId) throws CinemaHallNotFoundException;

}
