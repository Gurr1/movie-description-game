package xyz.engsmyre.moviedescriptiongame.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import xyz.engsmyre.moviedescriptiongame.dto.MovieSuggestions
import xyz.engsmyre.moviedescriptiongame.service.SuggestionService

@Controller
@RequestMapping("/game/suggestion")
class SuggestionsController(private val suggestionService: SuggestionService) {
    @GetMapping("")
    fun suggestMovies(searchQuery : String) : MovieSuggestions {
        suggestionService.findSearchResults(searchQuery)
        TODO("Implement me")
    }
}