package com.tw1stedrain.garyMedia.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TvSeasonRepo extends JpaRepository<TvSeason, Long> {

    List<TvSeason> findAllByOrderByTitle();

    List<TvSeason> findAllByOrderByNumOfEpisodes();

    List<TvSeason> findAllByOrderByGenre();

    List<TvSeason> findAllByOrderByRating();

    List<TvSeason> findAllByLoanedTrue();

    List<TvSeason> findByTitleContains(String title);
}
