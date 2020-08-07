package com.kjh.webservice.dto.songs;

import com.kjh.webservice.SongType;
import com.kjh.webservice.domain.songs.Songs;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SongsSaveRequestDto {

    private String title;
    private String artist;
    private String link;
    private String type;
    private int views;

    @Builder
    public SongsSaveRequestDto(String title, String artist, String link, String type) {
        this.title = title;
        this.artist = artist;
        this.link = link;
        this.type = type;
    }

    public Songs toEntity() {
        return Songs.builder()
                .title(title)
                .artist(artist)
                .link(link)
                .type(type)
                .build();
    }
}
