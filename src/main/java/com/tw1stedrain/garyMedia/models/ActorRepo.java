package com.tw1stedrain.garyMedia.models;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepo extends JpaRepository<Actor, Long> {

    List<Actor> findAllByOrderByFirstName();

    List<Actor> findAllByOrderByLastName();

    List<Actor> findByLastNameIgnoreCase(String keyword);
}
