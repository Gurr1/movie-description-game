package xyz.engsmyre.moviedescriptiongame.controller;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.engsmyre.moviedescriptiongame.domain.Rating;
import xyz.engsmyre.moviedescriptiongame.domain.Title;
import xyz.engsmyre.moviedescriptiongame.service.ImdbDatasetService;
import xyz.engsmyre.moviedescriptiongame.service.MovieService;

@RestController
@RequestMapping("/update")
public class AdminController {

    private final MovieService movieService;
    private final ImdbDatasetService imdbDatasetService;

    public AdminController(MovieService movieService, ImdbDatasetService imdbDatasetService) {
        this.movieService = movieService;
        this.imdbDatasetService = imdbDatasetService;
    }

    @GetMapping("/")
    public ResponseEntity<String> fetchUpdate() {
        Map<String, Rating> ratingMap = imdbDatasetService.getRatings();
        Map<String, Title> titleMap = imdbDatasetService.getTitles();
        movieService.updateMovies(titleMap, ratingMap);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
