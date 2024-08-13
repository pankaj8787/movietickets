package com.movietickets.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer cityId;

    @Column(nullable = false, name = "city_name")
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;
}
