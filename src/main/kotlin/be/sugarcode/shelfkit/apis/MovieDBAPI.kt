package be.sugarcode.shelfkit.apis

import be.sugarcode.shelfkit.apis.dtos.DetailedMovieDTO
import be.sugarcode.shelfkit.apis.mappers.MovieMapper
import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class MovieDBAPI(
    val movieMapper: MovieMapper = MovieMapper(),
    val client: WebClient = WebClient.create(),
    val dotenv: Dotenv = dotenv(),
) {
    fun findMoviesBySearchTerm(searchTerm: String): List<BasicMovieResult> {
        return client.get().uri(
            "https://api.themoviedb.org/3/search/movie?api_key=${dotenv["TMDB_KEY"]}&language=en-US&page=1&include_adult=false&query=$searchTerm"
        )
            .retrieve()
            .bodyToMono(MovieSearchResult::class.java)
            .block()!!.results
    }

    fun getMovieDetails(id: Int): DetailedMovieDTO {
        val result: DetailedMovieResult = client.get().uri(
            "https://api.themoviedb.org/3/movie/$id?api_key=${dotenv["TMDB_KEY"]}&language=en-US"
        )
            .retrieve()
            .bodyToMono(DetailedMovieResult::class.java)
            .block()!!

        return movieMapper.toDetailedMovieDTO(result)
    }
}
