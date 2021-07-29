package xyz.engsmyre.moviedescriptiongame.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record MovieDescription(String description) {

    @Override
    public String description() {
        return description;
    }
}
