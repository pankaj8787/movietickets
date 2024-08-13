package com.movietickets.controller;

import com.movietickets.entity.Showtime;
import com.movietickets.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movieshows")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    @CrossOrigin("*")
    @PostMapping(value = "moviesincityondate" )
    public ResponseEntity<List<Showtime>> getAllMoviesInCityOnDate(
            Integer cityId, String showDate) {
        LocalDate date = LocalDate.parse(showDate);
        List<Showtime> showtimes = showtimeService.getAllMoviesInCityOnDate(cityId, date);
        return ResponseEntity.ok(showtimes);
    }

    @CrossOrigin("*")
    @PostMapping(value = "theatresbymoviescityndate" )
    public ResponseEntity<List<Showtime>> getAllTheatreByMovieCityAndDate(
            Integer movieId, Integer cityId, String showDate) {
        LocalDate date = LocalDate.parse(showDate);
        List<Showtime> showtimes = showtimeService.getAllTheatreByMovieCityAndDate(movieId,cityId, date);
        return ResponseEntity.ok(showtimes);
    }

    @CrossOrigin("*")
    @PostMapping(value = "moviesintheatreondate" )
    public ResponseEntity<List<Showtime>> getAllMoviesInTheatreOnDate(
            Integer theatreId, String showDate) {
        LocalDate date = LocalDate.parse(showDate);
        List<Showtime> showtimes = showtimeService.getAllMoviesInTheatreOnDate(theatreId, date);
        return ResponseEntity.ok(showtimes);
    }

}
