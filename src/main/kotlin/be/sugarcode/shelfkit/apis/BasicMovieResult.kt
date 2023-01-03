package be.sugarcode.shelfkit.apis

import com.fasterxml.jackson.annotation.JsonProperty

class BasicMovieResult(
    val id: Int?,

    val title: String?,

    @JsonProperty("poster_path")
    val posterPath: String?
)