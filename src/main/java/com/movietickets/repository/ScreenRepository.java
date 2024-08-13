package com.movietickets.repository;

import com.movietickets.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {
    @Query("SELECT sc FROM Screen sc " +
//            "JOIN sc.theatre t " +
//            "JOIN t.city c " +
//            "WHERE sc.theatre.city.cityId = :cityId")
            "WHERE sc.screenId = :cityId")
    List<Screen> findAllScreensInCity(
            @Param("cityId") Integer cityId);
}
