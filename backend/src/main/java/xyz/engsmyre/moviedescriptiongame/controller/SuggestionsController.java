package xyz.engsmyre.moviedescriptiongame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.engsmyre.moviedescriptiongame.dto.MovieSuggestions;

@Controller
@RequestMapping("/game/suggestion")
public class SuggestionsController {

    @GetMapping
    public MovieSuggestions getMovieSuggestions() {
        return null;
    }
}
