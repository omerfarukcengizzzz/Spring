package com.cybertek.repository;

import com.cybertek.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ----------------------

    // Write a derived query to read movie cinema with id
    Optional<MovieCinema> findById(Long id);

    // Write a derived query to count all movie cinemas with a specific cinema id
    Integer countAllByCinemaId(Long id);

    // Write a derived query to count all movie cinemas with a specific movie id
    Integer countAllByMovieId(Long id);

    // Write a derived query to list all movie cinemas with after than a specific date
    List<MovieCinema> findAllByDateTimeIsAfter(LocalDateTime date);

    // Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findTop3OrderByMoviePrice();

    // Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findAllByMovieNameContaining(String name);

    // Write a derived query to list all movie cinemas in a specific location
    List<MovieCinema> findAllByCinemaLocationName(String name);

    // ------------------- JPQL QUERIES ----------------------

    // Write a JPQL query to list all movie cinemas with after a specific date
    @Query("select mc from MovieCinema mc where mc.dateTime > ?1")
    List<MovieCinema> listAllMovieCinemaAfterDate(LocalDateTime date);

    // ------------------- NATIVE QUERIES ----------------------

    // Write a native query to count all movie cinemas by cinema id
    @Query(value = "select count(*) from movie_cinema where cinema_id = ?1", nativeQuery = true)
    Integer countByCinemaId(Long id);

    // Write a native query that returns all movie cinemas by location name
    @Query(value = "select * from movie_cinema mc join cinema c on mc.cinema_id = c.id join location l on l.id = c.location_id where l.name = ?1", nativeQuery = true)
    List<MovieCinema> retrieveAllByLocationName(String locationName);

}
