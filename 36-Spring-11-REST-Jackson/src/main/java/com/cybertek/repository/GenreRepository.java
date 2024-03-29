package com.cybertek.repository;

import com.cybertek.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    // ------------------- JPQL QUERIES ----------------------

    // Write a JPQL query that returns all genres
    @Query("select g from Genre g")
    List<Genre> retrieveAllGenres();

    // ------------------- NATIVE QUERIES ----------------------

    // Write a native query that returns genres by containing name
    @Query(value = "select * from genre where name ilike concat('%', ?1, '%')", nativeQuery = true)
    List<Genre> findByNameContaining(String infix);

    @Query(value = "select count(*) from genre g join movie_genre_rel mgr on g.id = mgr.genre_id where g.id = ?1", nativeQuery = true)
    Integer countGenreNativeQuery(Long id);

}
