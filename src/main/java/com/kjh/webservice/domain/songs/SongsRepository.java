package com.kjh.webservice.domain.songs;

import com.kjh.webservice.SongType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface SongsRepository extends JpaRepository<Songs, Long> {

    @Query("SELECT p " +
            "FROM Songs p " +
            "ORDER BY p.views DESC")
    Stream<Songs> findAllDesc();

@Query("SELECT p " +
        "FROM Songs p " +
        "WHERE type = '0'" +
        "ORDER BY p.views DESC")
    Stream<Songs> findHiphopDesc();

    @Query("SELECT p " +
            "FROM Songs p " +
            "WHERE p.type = :type " +
            "ORDER BY p.views DESC")
    Stream<Songs> findByType(@Param("type") String type);
}
