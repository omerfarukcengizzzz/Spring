package com.cybertek.repository;

import com.cybertek.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
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

    // Write a JPQL query that returns a user read by username?

    // Write a JPQL query that returns all users?

    // ------------------- NATIVE QUERIES ----------------------

    // Write a native query that returns all users that contain a specific name?

    // Write a native query that returns all users?

    // Write a native query that returns all users in the range of ages?

    // Write a native query to read a user by email?

}
