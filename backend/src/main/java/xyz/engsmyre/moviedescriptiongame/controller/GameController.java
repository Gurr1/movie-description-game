package xyz.engsmyre.moviedescriptiongame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.engsmyre.moviedescriptiongame.dto.gameId.GameId;
import xyz.engsmyre.moviedescriptiongame.dto.MovieDescription;
import xyz.engsmyre.moviedescriptiongame.service.GameService;

@Controller()
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;
    private final SimpMessagingTemplate messagingTemplate;

    public GameController(GameService gameService, SimpMessagingTemplate messagingTemplate) {
        this.gameService = gameService;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping("/new")
    public ResponseEntity<GameId> startNewGameInstance() {
        GameId newGameId = this.gameService.generateNewGameId();
        this.gameService.generateNewGame(newGameId);
        return new ResponseEntity<>(newGameId, HttpStatus.ACCEPTED);
    }

    @MessageMapping("/subscribe/{gameId}")
    @SendTo("/topic/game/{gameId}")     // TODO This should give updates on the lobby.
    public String subscribeToGame(@DestinationVariable String gameId) throws Exception {      // TODO FIX So it's not string return.
        return "started new game with id " + gameId;
    }

    @MessageMapping("/next/")
    //@SendTo("/topic/game/{gameId}")
    public ResponseEntity<MovieDescription> nextQuestion(@RequestBody GameId gameId) {
        System.out.println(gameId);
        this.gameService.nextMovie(gameId);
        MovieDescription description = this.gameService.getMovieDescription();
        System.out.println(description);
        this.messagingTemplate.convertAndSend(String.format("/topic/game/%s", gameId.getGameId()), description);
        System.out.println(this.messagingTemplate.getDefaultDestination());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
