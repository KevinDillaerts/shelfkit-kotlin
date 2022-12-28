package be.sugarcode.shelfkit.services.dtos

class ItemDTO(
    val itemId: Int?,

    val type: String,

    val user: Int,

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