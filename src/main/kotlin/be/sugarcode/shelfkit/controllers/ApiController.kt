package be.sugarcode.shelfkit.controllers

import be.sugarcode.shelfkit.apis.CocktailAPIService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api")
class ApiController(val cocktailAPIService: CocktailAPIService) {

    @GetMapping
    fun getApiResult(): Mono<Any> {
        return cocktailAPIService.getMargartia()
    }
}