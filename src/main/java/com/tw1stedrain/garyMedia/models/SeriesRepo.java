package com.tw1stedrain.garyMedia.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeriesRepo extends JpaRepository<Series, Long> {

    List<Series> findAllByOrderByName();
}
