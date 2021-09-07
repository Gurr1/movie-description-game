package xyz.engsmyre.moviedescriptiongame.service

import org.springframework.stereotype.Service
import xyz.engsmyre.moviedescriptiongame.dto.MovieSuggestions
import xyz.engsmyre.moviedescriptiongame.repository.SuggestionsRepository
import xyz.engsmyre.moviedescriptiongame.tmdb.service.MovieService

@Service
class SuggestionService(private val movieService: MovieService,
                        private val suggestionsRepository: SuggestionsRepository) {

    fun findSearchResults(searchQuery : String) : MovieSuggestions {
        val anythingBeforeAnythingAfterRegex = "*$searchQuery*"
        val suggestions = suggestionsRepository.findBySearchMatchesRegex(anythingBeforeAnythingAfterRegex)
            .ifPresentOrElse(
                { suggestionDbEntry -> println(suggestionDbEntry) },
                { movieService.searchForMovies(searchQuery) }
            )

        TODO()
    }
}