package com.cybertek;

import com.cybertek.enums.MovieState;
import com.cybertek.enums.MovieType;
import com.cybertek.enums.UserRole;
import com.cybertek.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

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
    @Autowired
    MovieCinemaRepository movieCinemaRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;

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

        System.out.println("----------- MOVIE_CINEMA REPOSITORY -----------");
        System.out.println(movieCinemaRepository.findById(3l));
        System.out.println(movieCinemaRepository.countAllByCinemaId(7l));
        System.out.println(movieCinemaRepository.countAllByMovieId(9l));
        System.out.println(movieCinemaRepository.findAllByDateTimeIsAfter(LocalDateTime.now()));
        System.out.println(movieCinemaRepository.findFirst3ByOrderByMoviePrice());
        System.out.println(movieCinemaRepository.findAllByMovieNameContaining("The Gentleman"));
        System.out.println(movieCinemaRepository.findAllByCinemaLocationName("AMC Empire 25"));
        System.out.println(movieCinemaRepository.listAllMovieCinemaAfterDate(LocalDateTime.now()));
        System.out.println(movieCinemaRepository.countByCinemaId(2l));
        System.out.println(movieCinemaRepository.retrieveAllByLocationName("AMC Village 7"));
        System.out.println("-----------------------------------------------");

        System.out.println("----------- MOVIE REPOSITORY -----------");
        System.out.println(movieRepository.findByName("The Gentleman"));
        System.out.println(movieRepository.findAllByPriceBetween(BigDecimal.valueOf(10), BigDecimal.valueOf(16)));
        System.out.println(movieRepository.findByDurationIn(Arrays.asList(133, 135, 100, 129, 98)));
        System.out.println(movieRepository.findByReleaseDateAfter(LocalDate.now().minusYears(2)));
        System.out.println(movieRepository.findByStateAndType(MovieState.ACTIVE, MovieType.REGULAR));
        System.out.println(movieRepository.retrieveAllByPricesBetween(BigDecimal.valueOf(10), BigDecimal.valueOf(16)));
        System.out.println(movieRepository.retrieveAllMovieNames());
        System.out.println(movieRepository.findByMovieName("Tenet"));
        System.out.println(movieRepository.findByPriceBetween(BigDecimal.valueOf(10), BigDecimal.valueOf(20)));
        System.out.println(movieRepository.findByDurationBetween(Arrays.asList(10, 40, 100, 150)));
        System.out.println(movieRepository.findTop5ByPrice());
        System.out.println("----------------------------------------");

        System.out.println("----------- TICKET REPOSITORY -----------");
        System.out.println(ticketRepository.countAllByUserAccountName("Josie D Story"));
        System.out.println(ticketRepository.findByUserEmail("josie_story@email.com"));
        System.out.println(ticketRepository.countAllByMovieCinemaMovieId(1l));
        System.out.println(ticketRepository.findAllByDateTimeBetween(LocalDateTime.now().minusYears(10), LocalDateTime.now()));
        System.out.println(ticketRepository.findAllByUserAccountName("josieStory"));
        System.out.println(ticketRepository.retrieveAllByDateTimeBetween(LocalDateTime.now().minusYears(10), LocalDateTime.now()));
        System.out.println(ticketRepository.countAllByUserAccountId(1l));
        System.out.println(ticketRepository.countAllByDateTimeBetween(LocalDateTime.now().minusYears(10), LocalDateTime.now(), 3l));
        System.out.println(ticketRepository.returnAllDistinctTicketsByMovieName());
        System.out.println(ticketRepository.findAllByUserEmail("faith.p@email.com"));
        System.out.println(ticketRepository.retrieveAllTickets());
        System.out.println(ticketRepository.retrieveAllByUserNameContainingOrNameContainingOrMovieNameContaining("Faith R Parsons"));
        System.out.println("-----------------------------------------");

        System.out.println("----------- USER REPOSITORY -----------");
        System.out.println(userRepository.findAllByEmail("johnnie@email.com"));
        System.out.println(userRepository.findAllByUsername("faith"));
        System.out.println(userRepository.findAllByAccountNameContaining("R"));
        System.out.println(userRepository.findAllByAccountNameContainingIgnoreCase("r"));
        System.out.println(userRepository.findAllByAccountAgeGreaterThan(45));
        System.out.println(userRepository.findAllByUserEmail("josie_story@email.com"));
        System.out.println(userRepository.findAllByUsername("lawrence.f"));
        System.out.println(userRepository.retrieveAllUsers());
        System.out.println(userRepository.retrieveAllByNameContaining("E"));
        System.out.println(userRepository.retrieveAll());
        System.out.println(userRepository.retrieveAllByAgeBetween(25, 40));
        System.out.println(userRepository.findByEmail("johnnie@email.com"));
        System.out.println("---------------------------------------");

    }

}
