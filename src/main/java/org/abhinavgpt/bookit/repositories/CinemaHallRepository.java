package org.abhinavgpt.bookit.repositories;

import org.abhinavgpt.bookit.modals.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHall , Long> {

}
