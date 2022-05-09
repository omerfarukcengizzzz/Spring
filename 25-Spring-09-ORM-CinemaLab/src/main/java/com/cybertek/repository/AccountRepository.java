package com.cybertek.repository;

import com.cybertek.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ----------------------

    // Write a derived query to list all accounts with a specific country or state

    // Write a derived query to list all accounts with age lower than or equal to a specific value

}
