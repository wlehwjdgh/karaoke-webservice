package com.kjh.webservice.domain.musics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface SongsRepository extends JpaRepository<Songs, Long> {

    @Query("SELECT p " +
            "FROM Songs p " +
            "ORDER BY p.id DESC")
    Stream<Songs> findAllDesc();
}
