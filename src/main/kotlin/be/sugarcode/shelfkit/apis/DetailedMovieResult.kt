package be.sugarcode.shelfkit.apis

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

class DetailedMovieResult(
    val title: String,

    @JsonProperty("poster_path")
    val image: String?,

    val overview: String,

    @JsonProperty("imdb_id")
    val extLink: String,

    @JsonProperty("release_date")
    val released: LocalDate
)