package com.kjh.webservice.web;

import com.kjh.webservice.SongType;
import com.kjh.webservice.domain.songs.Songs;
import com.kjh.webservice.dto.songs.SongsMainResponseDto;
import com.kjh.webservice.dto.songs.SongsSaveRequestDto;
import com.kjh.webservice.service.SongsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {
    private SongsService songsService;

    private Environment env;

    @GetMapping("/hello")
    public String Hello() {
        return "HelloWorld";
    }

    /*
    Dto.toEntity를 통해서 바로 전달해도 되는데 굳이 Service에서 Dto를 받는 이유는 간단합니다.
    Controller와 Service 의 역할을 분리하기 위함입니다.
    비지니스 로직 & 트랜잭션 관리는 모두 Service에서 관리하고, View 와 연동되는 부분은 Controller에서 담당하도록 구성합니다.
    */
    @PostMapping("/add")
    public Long saveSongs(@RequestBody SongsSaveRequestDto dto) {
        return this.songsService.save(dto);
    }

    @GetMapping("/songs")
    public @ResponseBody
    List<SongsMainResponseDto> getAllSongs(Model model, Songs song) {
        if (song.getTitle() != null) {
            return songsService.findByTitle(song.getTitle());
        } else if (song.getArtist() != null) {
            return songsService.findByArtist(song.getArtist());
        } else if (song.getType() != null) {
            return songsService.findByTypeDesc(song.getType());
        }
        return songsService.findAllDesc();
    }

    @PostMapping("/songs/{songId}/update")
    public Long processUpdateSongForm(@PathVariable("songId") Long songId) {
        return this.songsService.update(songId);
    }

    @GetMapping("/songs/{songType}")
    public @ResponseBody
    List<SongsMainResponseDto> getSongsByType(Model model, @PathVariable("songType") String songType) {
        return songsService.findByTypeDesc(songType);
    }

    @GetMapping("/profile")
    public String getProfile() {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }
}
