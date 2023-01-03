package be.sugarcode.shelfkit.apis

import be.sugarcode.shelfkit.repositories.apis.GameAPIKeys
import be.sugarcode.shelfkit.repositories.apis.GameAPIRepository
import com.api.igdb.apicalypse.APICalypse
import com.api.igdb.request.IGDBWrapper
import com.api.igdb.request.IGDBWrapper.apiJsonRequest
import com.api.igdb.utils.Endpoints
import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@Service
@Transactional
class GameDBAPI(
    val gameApiRepository: GameAPIRepository,
) {

    var dotenv: Dotenv = dotenv()

    fun findGamesBySearchTerm(searchTerm: String): String {
        //TODO: add exception to throw statement
        val apiInfo: GameAPIKeys = gameApiRepository.findById("igdb").orElseThrow()
        var token = apiInfo.accessToken
        if (ChronoUnit.SECONDS.between(apiInfo.updatedAt, LocalDateTime.now()) > apiInfo.expiresIn) {
            token = updateGameAPIToken(apiInfo)
        }

        IGDBWrapper.setCredentials(dotenv["IGBDKEY_CLIENT_ID"], token)
        val apiCalypse = APICalypse()
            .fields("name, first_release_date, platforms.name, summary, url, cover.image_id, involved_companies.developer, involved_companies.company, involved_companies.company.name")
            .limit(20)
            .offset(0)
            .search(searchTerm)
            .buildQuery()

        return apiJsonRequest(Endpoints.GAMES, apiCalypse)
    }

    fun updateGameAPIToken(apiInfo: GameAPIKeys): String {
        val client: WebClient = WebClient.create()
        val newToken = client.get()
            .uri(" https://id.twitch.tv/oauth2/token?client_id=${dotenv["IGBDKEY_CLIENT_ID"]}&client_secret=${dotenv["IGBDKEY_CLIENT_SECRET"]}&grant_type=client_credentials")
            .retrieve()
            .bodyToMono(GameAPIKeys::class.java)
            .block()

        if (newToken != null) {
            apiInfo.accessToken = newToken.accessToken
            apiInfo.updatedAt = LocalDateTime.now()
            apiInfo.expiresIn = newToken.expiresIn
        }

        gameApiRepository.save(apiInfo)
        return apiInfo.accessToken
    }
}