package com.kjh.webservice.dto.songs;

import com.kjh.webservice.SongType;
import com.kjh.webservice.domain.songs.Songs;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class SongsMainResponseDto {
    private Long id;
    private String title;
    private String artist;
    private String link;
    private SongType type;
    private int views;
    private String modifiedDate;

    public SongsMainResponseDto(Songs entity) {
        id = entity.getId();
        title = entity.getTitle();
        artist = entity.getArtist();
        link = entity.getLink();
        type = entity.getType();
        views = entity.getViews();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
