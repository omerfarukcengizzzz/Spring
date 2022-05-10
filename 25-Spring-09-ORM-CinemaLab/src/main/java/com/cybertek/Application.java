package com.cybertek;

import com.cybertek.enums.UserRole;
import com.cybertek.repository.AccountRepository;
import com.cybertek.repository.CinemaRepository;
import com.cybertek.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    GenreRepository genreRepository;

    @PostConstruct
    public void test() {

        System.out.println("----------- ACCOUNT REPOSITORY -----------");
        System.out.println(accountRepository.findByCountryOrState("", "Kentucky"));
        System.out.println(accountRepository.findByAgeLessThanEqual(35));
        System.out.println(accountRepository.findByRole(UserRole.ADMIN));
        System.out.println(accountRepository.findByAgeIsBetween(25, 30));
        System.out.println(accountRepository.findByAddressStartingWith("6"));
        System.out.println(accountRepository.getAccountsByOrderByAgeDesc());
        System.out.println(accountRepository.getAllAccounts());
        System.out.println(accountRepository.getAllUserAccounts());
        System.out.println(accountRepository.getAccountsOrderedByAge());
        System.out.println(accountRepository.getAccountsByAgeLessThan(29));
        System.out.println(accountRepository.getAccountsByContaining("osi"));
        System.out.println("------------------------------------------");

        System.out.println("----------- CINEMA REPOSITORY -----------");
        System.out.println(cinemaRepository.findByName("Hall 1 - EMPIRE"));
        System.out.println(cinemaRepository.findTop3BySponsoredNameContaining("Kodak"));
        System.out.println(cinemaRepository.findAllByLocation_Country("United States"));
        System.out.println(cinemaRepository.findByNameOrSponsoredName("", "HBO"));
        System.out.println(cinemaRepository.findCinemaById(5l));
        System.out.println(cinemaRepository.getAllByLocation("United States"));
        System.out.println(cinemaRepository.getCinemaByNameContainingOrSponsoredNameContaining("Pont"));
        System.out.println(cinemaRepository.sortByName());
        System.out.println(cinemaRepository.findDistinctBySponsoredName());
        System.out.println("-----------------------------------------");

        System.out.println("----------- GENRE REPOSITORY -----------");
        System.out.println(genreRepository.retrieveAllGenres());
        System.out.println(genreRepository.findByNameContaining("Drama"));
        System.out.println("----------------------------------------");




    }

}
