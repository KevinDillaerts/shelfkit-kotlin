package be.sugarcode.shelfkit.apis.mappers

import be.sugarcode.shelfkit.apis.DetailedMovieResult
import be.sugarcode.shelfkit.apis.dtos.DetailedMovieDTO
import org.springframework.stereotype.Service

@Service
class MovieMapper {
    fun toDetailedMovieDTO(detailedMovieResult: DetailedMovieResult): DetailedMovieDTO {
        return DetailedMovieDTO(
            name = detailedMovieResult.title,
            image = detailedMovieResult.image,
            description = detailedMovieResult.overview,
            extLink = detailedMovieResult.extLink,
            released = detailedMovieResult.released.year
        )
    }
}