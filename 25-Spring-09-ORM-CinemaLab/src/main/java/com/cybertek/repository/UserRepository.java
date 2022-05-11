package com.cybertek.repository;

import com.cybertek.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ----------------------

    // Write a derived query to read a user with an email?
    List<User> findAllByEmail(String email);

    // Write a derived query to read a user with a username?
    List<User> findAllByUsername(String username);

    // Write a derived query to list all users that contain a specific name?
    List<User> findAllByAccountNameContaining(String infix);

    // Write a derived query to list all users that contain a specific name in the ignored case mode?
    List<User> findAllByAccountNameContainingIgnoreCase(String infix);

    // Write a derived query to list all users with an age greater than a specified age?
    List<User> findAllByAccountAgeGreaterThan(Integer age);

    // ------------------- JPQL QUERIES ----------------------

    // Write a JPQL query that returns a user read by email?
    @Query("select u from User u where u.email = ?1")
    List<User> findAllByUserEmail(String email);

    // Write a JPQL query that returns a user read by username?
    @Query("select u from User u where u.username = ?1")
    List<User> findUserByUsername(String username);

    // Write a JPQL query that returns all users?
    @Query("select u from User u")
    List<User> retrieveAllUsers();

    // ------------------- NATIVE QUERIES ----------------------

    // Write a native query that returns all users that contain a specific name?
    @Query(value = "select * from user_account ua join account_details ad on ua.account_details_id = ad.id where ad.name ilike concat ('%', ?1, '%')", nativeQuery = true)
    List<User> retrieveAllByNameContaining(String name);

    // Write a native query that returns all users?
    @Query(value = "select * from user_account", nativeQuery = true)
    List<User> retrieveAll();

    // Write a native query that returns all users in the range of ages?
    @Query(value = "select * from user_account ua join account_details ad on ua.account_details_id = ad.id where ad.age between ?1 and ?2",nativeQuery = true)
    List<User> retrieveAllByAgeBetween(Integer age1, Integer age2);

    // Write a native query to read a user by email?
    @Query(value = "select * from user_account where email = ?1", nativeQuery = true)
    List<User> findByEmail(String email);

}
