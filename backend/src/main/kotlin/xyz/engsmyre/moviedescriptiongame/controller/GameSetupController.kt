package xyz.engsmyre.moviedescriptiongame.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import xyz.engsmyre.moviedescriptiongame.dto.gameId.GameId
import xyz.engsmyre.moviedescriptiongame.service.GameService

@Controller
@RequestMapping("/game")
class GameSetupController(private val gameService: GameService) {
    @GetMapping("/new")
    fun startNewGameInstance(): ResponseEntity<GameId> {
        val newGameId = gameService.generateNewGameId()
        gameService.generateNewGame(newGameId)
        return ResponseEntity(newGameId, HttpStatus.ACCEPTED)
    }

    @MessageMapping("/subscribe/{gameId}")
    @SendTo("/topic/game/{gameId}") // TODO This should give updates on the lobby.
    @Throws(Exception::class)
    fun subscribeToGame(@DestinationVariable gameId: String): String {      // TODO FIX So it's not string return.
        return "started new game with id $gameId"
    }
}