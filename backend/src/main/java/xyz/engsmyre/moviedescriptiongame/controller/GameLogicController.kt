package xyz.engsmyre.moviedescriptiongame.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import xyz.engsmyre.moviedescriptiongame.dto.GuessResponse
import xyz.engsmyre.moviedescriptiongame.dto.MovieDescription
import xyz.engsmyre.moviedescriptiongame.dto.gameId.GameId
import xyz.engsmyre.moviedescriptiongame.service.GameService

@Controller
@RequestMapping("/game")
class GameLogicController(private val gameService: GameService, private val messagingTemplate: SimpMessagingTemplate) {
    @MessageMapping("/next/")
    fun nextQuestion(@RequestBody gameId: GameId): ResponseEntity<MovieDescription> {
        gameService.nextMovie(gameId)
        val description = gameService.getMovieDescription()
        messagingTemplate.convertAndSend(String.format("/topic/game/%s", gameId.gameId), description)
        return ResponseEntity(HttpStatus.OK)
    }

    @MessageMapping("/guess/")
    fun guessMovie(): ResponseEntity<GuessResponse>? {
        return null
    }
}