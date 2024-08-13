package com.movietickets.repository;

import com.movietickets.entity.SeatBooked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatBookedRepository extends JpaRepository<SeatBooked, Integer> {}
