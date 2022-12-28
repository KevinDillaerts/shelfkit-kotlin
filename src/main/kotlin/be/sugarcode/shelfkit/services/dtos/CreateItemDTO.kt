package be.sugarcode.shelfkit.services.dtos

class CreateItemDTO(
    val typeId: Int,

    val userId: Int,

    val imageLink: String,

    val itemName: String,

    val isInCollection: Int?,

    val formatId: Int?,

    val platform: String?,

    val description: String,

    val userComment: String?,

    val externalLink: String?,

    val quantity: Int?,

    val artist: String?,

    val releaseYear: Int?,
)