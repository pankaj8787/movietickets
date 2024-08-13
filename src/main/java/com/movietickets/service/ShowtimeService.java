package com.movietickets.service;

import com.movietickets.entity.Screen;
import com.movietickets.entity.Showtime;
import com.movietickets.repository.ScreenRepository;
import com.movietickets.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Autowired
    private ScreenRepository screenRepository;

    public List<Showtime> getAllTheatreByMovieCityAndDate(Integer movieId, Integer cityId, LocalDate showDate) {
        return showtimeRepository.findTheatreByMovieCityAndDate(movieId, cityId, showDate);
    }

    public List<Showtime> getAllMoviesInCityOnDate(Integer cityId, LocalDate showDate) {
        List<Screen> allScreensInCity = screenRepository.findAllScreensInCity(cityId);
        System.out.println(allScreensInCity.size());
        return showtimeRepository.findAllMoviesInCityOnDate(cityId, showDate);
    }

    public List<Showtime> getAllMoviesInTheatreOnDate(Integer theatreId, LocalDate showDate) {
        return showtimeRepository.findAllMoviesInTheatreOnDate(theatreId, showDate);
    }



}
