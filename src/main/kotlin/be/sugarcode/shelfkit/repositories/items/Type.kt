package be.sugarcode.shelfkit.repositories.items

import jakarta.persistence.*

@Entity
@Table(name = "type")
class Type(
    @Column(name = "name")
    val typeName: String,

    @Column(name = "is_predefined")
    val isPredefined: Int?,

    @Column(name = "item_name")
    val itemName: String,

    @Column(name = "image")
    val image: String,

    @Column(name = "artist", nullable = true)
    val artist: String?,

    @Column(name = "released", nullable = true)
    val releaseYear: String?,

    @Column(name = "format", nullable = true)
    val formatId: String?,

    @Column(name = "platform", nullable = true)
    val platform: String?,

    @Column(name = "is_in_collection", nullable = true)
    val isInCollection: String?,

    @Column(name = "quantity", nullable = true)
    val quantity: String?,

    @Column(name = "description")
    val description: String,

    @Column(name = "user_comment", nullable = true)
    val userComment: String?,

    @Column(name = "ext_link", nullable = true)
    val externalLink: String?,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null
)