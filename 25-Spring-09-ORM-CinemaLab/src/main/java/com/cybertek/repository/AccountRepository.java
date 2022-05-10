package com.cybertek.repository;

import com.cybertek.entity.Account;
import com.cybertek.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ----------------------

    // Write a derived query to list all accounts with a specific country or state
    List<Account> findByCountryOrState(String country, String state);

    // Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(Integer age);

    // Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole role);

    // Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeIsBetween(Integer age1, Integer age2);

    // Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressStartingWith(String prefix);

    // Write a derived query to sort the list of accounts with age
    List<Account> getAccountsByOrderByAgeDesc();

    // ------------------- JPQL QUERIES ----------------------

    // Write a JPQL query that returns all accounts
    @Query("select a from Account a")
    List<Account> getAllAccounts();

    // Write a JPQL query to list all user accounts
    @Query("select a from Account a where a.role = 'USER'")
    List<Account> getAllUserAccounts();

    // Write a JPQL query to sort all accounts with age
    @Query("select a from Account a order by a.age")
    List<Account> getAccountsOrderedByAge();

    // ------------------- NATIVE QUERIES ----------------------

    // Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from account_details where age < ?1", nativeQuery = true)
    List<Account> getAccountsByAgeLessThan(Integer age);

    // Write a native query to read all accounts that a specific value can be containable in the name, address, country, state, city
    @Query(value = "select * from account_details a where a.name ilike concat('%', ?1, '%') or a.address ilike concat('%', ?1, '%') or a.country ilike concat('%', ?1, '%') or a.state ilike concat('%', ?1, '%') or a.city ilike concat('%', ?1, '%')", nativeQuery = true)
    List<Account> getAccountsByContaining(String infix);

}
