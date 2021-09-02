package xyz.engsmyre.moviedescriptiongame.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

open class CustomException(status: HttpStatus, reason: String?) : ResponseStatusException(status, reason) {
    override fun getMostSpecificCause(): Throwable? {
        return Throwable()
    }

    @Synchronized
    override fun fillInStackTrace(): Throwable {
        return this
    }
}