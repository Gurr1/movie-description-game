package xyz.engsmyre.moviedescriptiongame.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/game")
@Controller
public class GameController {

    @MessageMapping("/new")     // TODO This should in a multiplayer version be an @DestinationVariable Instead.
    @SendTo("/topic/new_game")
    public ResponseEntity<String> startNewGame() throws Exception {      // TODO FIX So it's not string.
        return null;
    }

    @GetMapping("/")
    public ResponseEntity<String> nextQuestion() {
        return null;
    }
}
