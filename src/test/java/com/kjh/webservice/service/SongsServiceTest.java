package com.kjh.webservice.service;

import com.kjh.webservice.SongType;
import com.kjh.webservice.domain.songs.Songs;
import com.kjh.webservice.domain.songs.SongsRepository;
import com.kjh.webservice.dto.songs.SongsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongsServiceTest {

    @Autowired
    private SongsService songsService;

    @Autowired
    private SongsRepository songsRepository;

    @After
    public void cleanup () {
        songsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_songs테이블에_저장된다 () {
        //given
        SongsSaveRequestDto dto = SongsSaveRequestDto.builder()
                .title("METEOR")
                .artist("창모")
                .type("hiphop")
                .link("acCzZd6DAD4")
                .build();

        //when
        songsService.save(dto);

        //then
        Songs songs = songsRepository.findAll().get(0);
        assert(songs.getTitle().equals(dto.getTitle()));
        assert(songs.getArtist().equals(dto.getArtist()));
        assert(songs.getType().equals(dto.getType()));
        assert(songs.getLink().equals(dto.getLink()));
    }
}
