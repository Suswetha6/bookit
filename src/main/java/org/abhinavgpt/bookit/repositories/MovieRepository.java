package org.abhinavgpt.bookit.repositories;

import org.abhinavgpt.bookit.modals.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Override
    Optional<Movie> findById(Long Id) ;

}
