package xyz.engsmyre.moviedescriptiongame.tmdb.domain;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class PopularMovieRequest {
    private final String apiKey;
    private int page;
    private int voteCount;

    public PopularMovieRequest(String apiKey, int page, int voteCount) {
        this.apiKey = apiKey;
        this.page = page;
        this.voteCount = voteCount;
    }

    public PopularMovieRequest( String apiKey) {
        this.apiKey = apiKey;
    }

    public MultiValueMap<String, String> createParamsMap() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("api_key", apiKey);
        params.add("language", "en-US");
        params.add("sort_by", "popularity.desc");
        params.add("include_adult", "false");
        params.add("page", String.valueOf(page));
        params.add("vote_count.gte", String.valueOf(voteCount));
        return params;
    }
}
