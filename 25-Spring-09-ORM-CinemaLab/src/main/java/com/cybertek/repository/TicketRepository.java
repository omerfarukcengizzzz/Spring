package com.cybertek.repository;

import com.cybertek.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ----------------------

    // Write a derived query to count how many tickets a user bought
    Integer countAllByUserAccountName(String name);

    // Write a derived query to list all tickets by specific email
    List<Ticket> findByUserEmail(String email);

    // Write a derived query to count how many tickets are sold for a specific movie
    Optional<Integer> countAllByMovieCinemaMovieId(Long id);

    // Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime dateTime2);

    // ------------------- JPQL QUERIES ----------------------

    // Write a JPQL query that returns all tickets are bought from a specific user
    @Query("select t from Ticket t where t.user.username = ?1")
    List<Ticket> findAllByUserAccountName(String name);

    // Write a JPQL query that returns all tickets between a range of dates
    @Query("select t from Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> retrieveAllByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime dateTime2);

    // ------------------- NATIVE QUERIES ----------------------

    // Write a native query to count the number of tickets a user bought
    @Query(value = "select count(*) from ticket where user_account_id = ?1", nativeQuery = true)
    Optional<Integer> countAllByUserAccountId(Long id);

    // Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "select count(*) from ticket where date_time between ?1 and ?2 and user_account_id = ?3", nativeQuery = true)
    Optional<Integer> countAllByDateTimeBetween(LocalDateTime start, LocalDateTime end, Long id);

    // Write a native query to distinct all tickets by movie name

    // Write a native query to find all tickets by user email

    // Write a native query that returns all tickets

    // Write a native query to list all tickets where a specific value should be containable in the username or name or movie name

}
