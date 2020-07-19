package com.kjh.webservice.domain.songs;

import com.kjh.webservice.SongType;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongsRepositoryTest {

    @Autowired
    SongsRepository songsRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        songsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        songsRepository.save(Songs.builder()
                .title("METEOR")
                .artist("창모")
                .link("acCzZd6DAD4")
                .type(SongType.HIPHOP)
                .build());
        //when
        List<Songs> songsList = songsRepository.findAll();

        //then
        Songs songs = songsList.get(0);
        assert(songs.getTitle().equals("METEOR"));
        assert(songs.getArtist().equals("창모"));
        assert(songs.getType().equals(SongType.HIPHOP));
        assert(songs.getLink().equals("acCzZd6DAD4"));
    }

    @Test
    public void BaseTimeEntity_등록 () {
        //given
        LocalDateTime now = LocalDateTime.now();
        songsRepository.save(Songs.builder()
                .title("METEOR")
                .artist("창모")
                .type(SongType.HIPHOP)
                .link("acCzZd6DAD4")
                .build());

        //when
        List<Songs> songsList = songsRepository.findAll();

        //then
        Songs songs = songsList.get(0);
        assert(songs.getCreatedDate().isAfter(now));
        assert(songs.getModifiedDate().isAfter(now));

    }
}
