package xyz.engsmyre.moviedescriptiongame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.engsmyre.moviedescriptiongame.dto.MovieDescription;
import xyz.engsmyre.moviedescriptiongame.service.GameService;
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie;

@Controller
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @MessageMapping("/new")     // TODO This should in a multiplayer version be an @DestinationVariable Instead.
    @SendTo("/topic/game")
    public String startNewGame() throws Exception {      // TODO FIX So it's not string.
        return "started new game";
    }

    @MessageMapping("/next_description")
    @SendTo("/topic/game")
    public MovieDescription nextQuestion() {
        //this.gameService.nextMovie();
        MovieDescription description = this.gameService.getMovieDescription();
        System.out.println(description);
        return description;
    }
}
