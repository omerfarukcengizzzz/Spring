package com.cybertek.controller;

import com.cybertek.entity.Cinema;
import com.cybertek.repository.CinemaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinema")
@Tag(name = "Cinema", description = "Cinema API")
public class CinemaController {

    @Autowired
    private CinemaRepository cinemaRepository;

    @GetMapping
    @Operation(summary = "Get all cinemas from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Cinema.class))}),
            @ApiResponse(responseCode = "400", description = "Something went wrong", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cinema not found", content = @Content)
    })
    public List<Cinema> readAllCinemas() {
        return cinemaRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get cinema by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cinema is successfully retrieved", content = @Content),
            @ApiResponse(responseCode = "400", description = "Cinema cannot be retrieved", content = @Content)
    })
    public Cinema getCinemaById(@PathVariable Long id) {
        return cinemaRepository.findCinemaById(id).get();
    }

}
