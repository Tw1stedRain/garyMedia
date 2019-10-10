package com.tw1stedrain.garyMedia.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Long> {

    List<Movie> findAllByOrderByTitle();

    List<Movie> findAllByOrderByDurationInMinutes();

    List<Movie> findAllByOrderByGenre();

    List<Movie> findAllByOrderByRating();
}
