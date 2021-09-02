package xyz.engsmyre.moviedescriptiongame.tmdb.domain

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

class PopularMovieRequest {
    private val apiKey: String
    private val page: Int
    private val voteCount: Int

    constructor(apiKey: String, page: Int, voteCount: Int) {
        this.apiKey = apiKey
        this.page = page
        this.voteCount = voteCount
    }

    constructor(apiKey: String, voteCount: Int) {
        this.apiKey = apiKey
        page = 1
        this.voteCount = voteCount
    }

    fun createParamsMap(): MultiValueMap<String, String> {
        val params: MultiValueMap<String, String> = LinkedMultiValueMap()
        params.add("api_key", apiKey)
        params.add("language", "en-US")
        params.add("sort_by", "popularity.desc")
        params.add("include_adult", "false")
        params.add("page", page.toString())
        params.add("vote_count.gte", voteCount.toString())
        return params
    }
}