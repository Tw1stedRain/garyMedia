package com.tw1stedrain.garyMedia.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepo extends JpaRepository<Wish, Long> {

    List<Wish> findAllByOrderByTitle();

    List<Wish> findAllByOrderByTvOrMovie();

    List<Wish> findByTitleContains(String title);

}
