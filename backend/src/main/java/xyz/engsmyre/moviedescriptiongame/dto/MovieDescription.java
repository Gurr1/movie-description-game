package xyz.engsmyre.moviedescriptiongame.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record MovieDescription(String description) {

    public String description() {
        return description;
    }
}
