package xyz.engsmyre.moviedescriptiongame.tmdb.exception

import org.springframework.http.HttpStatus
import xyz.engsmyre.moviedescriptiongame.exceptions.CustomException

class TmdbCommunicationFailedException(reason: String?) :
    CustomException(HttpStatus.INTERNAL_SERVER_ERROR, "COULD_NOT_UPDATE_MOVIE_CACHE") {
    constructor(e: Exception) : this(e.message) {
        println(e)
    }

    init {
        println("communication with TMDB failed with underlying reason \n$reason") // TODO LOGGING
    }
}