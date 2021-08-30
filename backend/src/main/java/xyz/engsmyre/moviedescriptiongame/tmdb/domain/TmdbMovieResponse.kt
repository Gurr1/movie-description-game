package xyz.engsmyre.moviedescriptiongame.tmdb.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class TmdbMovieResponse {
    @JsonProperty("total_pages")
    private val nPages = 0

    @JsonProperty("total_results")
    private val nResults = 0

    @JsonProperty("page")
    val page = 0

    @JsonProperty("results")
    val movies: List<Movie>? = null
    fun getnPages(): Int {
        return nPages
    }

    fun getnResults(): Int {
        return nResults
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as TmdbMovieResponse
        return nPages == that.nPages && nResults == that.nResults && page == that.page && movies == that.movies
    }

    override fun hashCode(): Int {
        return Objects.hash(nPages, nResults, page, movies)
    }

    override fun toString(): String {
        return "TmdbMovieResponse{" +
                "nPages=" + nPages +
                ", nResults=" + nResults +
                ", page=" + page +
                ", movies=" + movies +
                '}'
    }
}