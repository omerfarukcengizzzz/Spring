package com.cybertek.repository;

import com.cybertek.entity.Cinema;
import com.cybertek.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ----------------------

    // Write a derived query to get cinema with a specific name
    List<Cinema> findByName(String name);

    // Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3BySponsoredNameContaining(String infix);

    // Write a derived query to list all cinemas in a specific country
    List<Cinema> findAllByLocation_Country(String country);

    // Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findByNameOrSponsoredName(String name, String sponsoredName);

    // ------------------- JPQL QUERIES ----------------------

    // Write a JPQL query to read the cinema name with a specific id
    @Query("select c.name from Cinema c where c.id = :id")
    Optional<Cinema> findCinemaById(@Param("id") Integer id);

    // ------------------- NATIVE QUERIES ----------------------

    // Write a native query to read all cinemas by location country
    @Query(value = "select * from cinema c join location l on l.location_id = c.location_id where l.country = ?1", nativeQuery = true)
    List<Cinema> getAllByLocation(String country);

    // Write a native query to read all cinemas by name or sponsored name containing a specific pattern
    @Query(value = "select * from cinema where name ilike concat('%', '?1', '%') or sponsored_name ilike concat('%', '?1', '%')", nativeQuery = true)
    List<Cinema> getCinemaByNameContainingOrSponsoredNameContaining(String infix);

    // Write a native query to sort all cinemas by name
    @Query(value = "select * from cinema order by name", nativeQuery = true)
    List<Cinema> sortByName();

    // Write a native query to distinct all cinemas by sponsored name
    @Query(value = "select distinct sponsored_name from cinema", nativeQuery = true)
    List<String> findDistinctBySponsoredName();

}
