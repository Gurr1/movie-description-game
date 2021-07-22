package xyz.engsmyre.moviedescriptiongame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.engsmyre.moviedescriptiongame.service.MovieService;

@RestController
@RequestMapping("/update")
public class AdminController {

    private final MovieService movieService;

    public AdminController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public ResponseEntity<String> fetchUpdate() {
        movieService.updateMovies();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
