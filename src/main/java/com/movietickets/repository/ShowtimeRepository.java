package com.movietickets.repository;

import com.movietickets.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {

    @Query("SELECT s FROM Showtime s JOIN s.screen sc JOIN sc.theatre t JOIN t.city c WHERE s.movie.id = :movieId AND c.cityId = :cityId AND s.showDate = :showDate")
    List<Showtime> findTheatreByMovieCityAndDate(
            @Param("movieId") Integer movieId,
            @Param("cityId") Integer cityId,
            @Param("showDate") LocalDate showDate);

    @Query("SELECT s FROM Showtime s " +
            "JOIN s.screen sc " +
            "JOIN sc.theatre t " +
            "JOIN t.city c " +
            "WHERE c.cityId = :cityId  AND s.showDate = :showDate")
    List<Showtime> findAllMoviesInCityOnDate(
            @Param("cityId") Integer cityId,
            @Param("showDate") LocalDate showDate);

    @Query("SELECT s FROM Showtime s " +
            "WHERE s.screen.theatre.theatreId = :theatreId  AND s.showDate = :showDate")
    List<Showtime> findAllMoviesInTheatreOnDate(
            @Param("theatreId") Integer theatreId,
            @Param("showDate") LocalDate showDate);

}
