package xyz.engsmyre.moviedescriptiongame.dto

import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
data class MovieDescription(val description : String)