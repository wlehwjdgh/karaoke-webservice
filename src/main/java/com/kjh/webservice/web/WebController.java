package com.kjh.webservice.web;

import com.kjh.webservice.SongType;
import com.kjh.webservice.domain.songs.Songs;
import com.kjh.webservice.dto.songs.SongsMainResponseDto;
import com.kjh.webservice.service.SongsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Stream;

@Controller
@AllArgsConstructor
public class WebController {
    private SongsService songsService;

    @GetMapping("/management/songs")
    public String getAllSongsInManageMode(Model model) {
        model.addAttribute("songs", songsService.findAllDesc());
        return "main";
    }

    @GetMapping("/management/songs/{songType}")
    public String getSongsByTypeInManageMode (Model model, @PathVariable("songType") String songType) {
        model.addAttribute("songs", songsService.findByTypeDesc(songType));
        return "main";
    }

    /*
    @GetMapping("/songs")
    public @ResponseBody List<SongsMainResponseDto> getAllSongs(Model model) {
       return songsService.findAllDesc();
    }
     */
    @GetMapping("/songs")
    public @ResponseBody List<SongsMainResponseDto> getAllSongs(Model model, Songs song) {
        if(song.getTitle() != null) {
            return songsService.findByTitle(song.getTitle());
        } else if(song.getArtist() != null) {
            return songsService.findByArtist(song.getArtist());
        } else if(song.getType() != null) {
            return songsService.findByTypeDesc(song.getType());
        }
        return songsService.findAllDesc();
    }


    @GetMapping("/songs/{songType}")
    public @ResponseBody List<SongsMainResponseDto> getSongsByType (Model model, @PathVariable("songType") String songType) {
        return songsService.findByTypeDesc(songType);
    }
}
