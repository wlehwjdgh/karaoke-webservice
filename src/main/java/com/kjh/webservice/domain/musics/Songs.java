package com.kjh.webservice.domain.musics;

import com.kjh.webservice.SongType;
import com.kjh.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Songs extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String artist;

    @Column(nullable = false)
    private SongType type;

    @Column(nullable = false)
    private String link;

    private int views;


    @Builder
    public Songs(String title, String artist, String link, SongType type) {
        this.title = title;
        this.artist = artist;
        this.type = type;
        this.link = link;
    }
}
