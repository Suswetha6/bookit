package org.abhinavgpt.bookit.services.cinemahall;

import org.abhinavgpt.bookit.exceptions.CinemaHallNotFoundException;
import org.abhinavgpt.bookit.modals.CinemaHall;
import org.abhinavgpt.bookit.repositories.CinemaHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface CinemaHallService {

    CinemaHall addCinemaHall(CinemaHall cinemaHall);

    CinemaHall updateCinemaHall(CinemaHall updatedCinemaHall);

    void deleteCinemaHall(Long hallId);

    List<CinemaHall> getAllCinemaHalls();

    CinemaHall getCinemaHallById(Long hallId) throws CinemaHallNotFoundException;

}
