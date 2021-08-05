package xyz.engsmyre.moviedescriptiongame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.engsmyre.moviedescriptiongame.dto.GameId;
import xyz.engsmyre.moviedescriptiongame.dto.MovieDescription;
import xyz.engsmyre.moviedescriptiongame.dto.MovieSuggestions;
import xyz.engsmyre.moviedescriptiongame.service.GameService;
import xyz.engsmyre.moviedescriptiongame.tmdb.domain.Movie;

@Controller()
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/new")
    public ResponseEntity<GameId> startNewGameInstance() {
        GameId newGameId = this.gameService.generateNewGameId();
        return new ResponseEntity<>(newGameId, HttpStatus.ACCEPTED); // TODO Generate instance code.
    }

    @MessageMapping("/subscribe/{gameId}")
    @SendTo("/topic/game/{gameId}")
    public String subscribeToGame(@DestinationVariable String gameId) throws Exception {      // TODO FIX So it's not string return.
        return "started new game with id " + gameId;
    }

    @MessageMapping("/next_description")
    @SendTo("/topic/game/{gameId}")
    public MovieDescription nextQuestion() {
        this.gameService.nextMovie();
        MovieDescription description = this.gameService.getMovieDescription();
        System.out.println(description);
        return description;
    }

    @MessageMapping("/suggestion")
    @SendTo("/topic/suggestion")
    public MovieSuggestions getMovieSuggestions() {
        return null;
    }
}
