package xyz.engsmyre.moviedescriptiongame.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import xyz.engsmyre.moviedescriptiongame.db.MovieStorage
import java.util.*

@Repository
interface MovieStoreRepository : CrudRepository<MovieStorage, String> {
    fun findMovieStorageByStorageKey(key: String): Optional<MovieStorage>
}