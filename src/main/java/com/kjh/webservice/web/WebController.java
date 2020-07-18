package com.kjh.webservice.web;

import com.kjh.webservice.service.SongsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {
    private SongsService songsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("songs", songsService.findAllDesc());
        return "main";
    }
}
