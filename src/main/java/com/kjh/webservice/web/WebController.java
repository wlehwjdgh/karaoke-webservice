package com.kjh.webservice.web;

import com.kjh.webservice.SongType;
import com.kjh.webservice.domain.songs.Songs;
import com.kjh.webservice.dto.songs.SongsMainResponseDto;
import com.kjh.webservice.dto.songs.SongsSaveRequestDto;
import com.kjh.webservice.service.SongsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String getSongsByTypeInManageMode(Model model, @PathVariable("songType") String songType) {
        model.addAttribute("songs", songsService.findByTypeDesc(songType));
        return "main";
    }
}
