package xyz.engsmyre.moviedescriptiongame.config

import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import xyz.engsmyre.moviedescriptiongame.dto.gameId.GameId
import xyz.engsmyre.moviedescriptiongame.dto.gameId.GameIdConverter

@Configuration
@EnableWebMvc
open class WebMvcConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
    }

    override fun addFormatters(registry: FormatterRegistry) {
        registry.addConverter(GameIdConverter())
        super.addFormatters(registry)
    }
}