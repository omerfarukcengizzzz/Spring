package com.cybertek.controller;

import com.cybertek.entity.Genre;
import com.cybertek.entity.MovieCinema;
import com.cybertek.repository.GenreRepository;
import com.cybertek.repository.MovieCinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebFluxController {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

    @Autowired
    private MovieCinemaRepository movieCinemaRepository;
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/flux-movie-cinema")
    public Flux<MovieCinema> readAllMovieCinemaFlux() {
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

    @GetMapping("/mono-movie-cinema/{id}")
    public Mono<MovieCinema> readByIdMono(@PathVariable Long id) {
        return Mono.just(movieCinemaRepository.findById(id).get());
    }

    @GetMapping("/mono-movie-cinema")
    public Mono<MovieCinema> readByIdRequestParam(@RequestParam Long id) {
        return Mono.just(movieCinemaRepository.findById(id).get());
    }

    @PostMapping("/create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre) {
        return Mono.just(genreRepository.save(genre));

    }

    @PutMapping("/update-genre")
    public Mono<Genre> updateGenre(@RequestBody Genre genre) {
        return Mono.just(genreRepository.save(genre));
    }

    @DeleteMapping("/delete-genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable Long id) {
        genreRepository.deleteById(id);
        return Mono.empty();
    }

    // --------------- WebClient Example ----------------

    @GetMapping("/flux")
    public Flux<MovieCinema> readWithWebClient() {
        return webClient
                .get()
                .uri("/flux-movie-cinema")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinema.class);
    }

    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable Long id) {
        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}", id)
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }

    @GetMapping("/mono-rp")
    public Mono<MovieCinema> readMonoWithWebClientRequestParam(@RequestParam Long id) {
        return webClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/mono-movie-cinema")
                                .queryParam("id", id)
                                .build())
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }

    @PostMapping("/create")
    public Mono<Genre> createGenreWithWebClient(@RequestBody Genre genre) {
        return webClient
                .post()
                .uri("/create-genre")
                .body(Mono.just(genre), Genre.class)
                .retrieve()
                .bodyToMono(Genre.class);
    }

}
