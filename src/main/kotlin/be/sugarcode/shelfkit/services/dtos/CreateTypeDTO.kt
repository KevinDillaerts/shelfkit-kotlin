package be.sugarcode.shelfkit.services.dtos

class CreateTypeDTO(
    val typeName: String,

    val isPredefined: Int?,

    val itemName: String,

    val image: String,

    val artist: String?,

    val releaseYear: String?,

    val formatId: String?,

    val platform: String?,

    val isInCollection: String?,

    val quantity: String?,

    val description: String,

    val userComment: String?,

    val externalLink: String?
)