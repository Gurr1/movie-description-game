package xyz.engsmyre.moviedescriptiongame.dto;

import java.util.List;

public record MovieSuggestions(List<String> suggestions) {

    public List<String> getSuggestions() {
        return suggestions;
    }
}
