package xyz.engsmyre.moviedescriptiongame

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class MovieDescriptionGameApplication {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            runApplication<MovieDescriptionGameApplication>()
        }
    }
}