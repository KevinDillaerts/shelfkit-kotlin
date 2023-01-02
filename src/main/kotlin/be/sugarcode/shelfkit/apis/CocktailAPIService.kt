package be.sugarcode.shelfkit.apis

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class CocktailAPIService(var client: WebClient = WebClient.create("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita")) {

    fun getMargartia(): Mono<Any> {
        return client.get()
            .retrieve()
            .bodyToMono(Any::class.java)
    }
}