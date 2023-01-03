package be.sugarcode.shelfkit.controllers

import be.sugarcode.shelfkit.apis.BasicMovieResult
import be.sugarcode.shelfkit.apis.GameDBAPI
import be.sugarcode.shelfkit.apis.MovieDBAPI
import be.sugarcode.shelfkit.apis.dtos.DetailedMovieDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ApiController(val movieDBAPI: MovieDBAPI, val gameDBAPI: GameDBAPI) {

    @GetMapping("/movie")
    fun getMovieApiResult(@RequestParam search: String): List<BasicMovieResult> {
        return movieDBAPI.findMoviesBySearchTerm(search)
    }

    @GetMapping("/movie/{id}")
    fun getMovieDetails(@PathVariable id: Int): DetailedMovieDTO {
        return movieDBAPI.getMovieDetails(id)
    }

    @GetMapping("/game")
    fun getGameApiResult(@RequestParam search: String): String {
        return gameDBAPI.findGamesBySearchTerm(search)
    }
}