package xyz.engsmyre.moviedescriptiongame.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import xyz.engsmyre.moviedescriptiongame.db.MovieSuggestion
import java.util.*

@Repository
interface SuggestionsRepository : CrudRepository<MovieSuggestion, String> {
    fun findBySearchMatchesRegex(regex : String) : Optional<MovieSuggestion>
}