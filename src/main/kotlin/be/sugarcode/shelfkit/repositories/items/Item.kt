package be.sugarcode.shelfkit.repositories.items

import be.sugarcode.shelfkit.repositories.users.User
import jakarta.persistence.*

@Entity
@Table(name = "item")
class Item(
    @ManyToOne
    @JoinColumn(name = "type_id")
    val type: Type,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @Column(name = "image_link")
    val imageLink: String,

    @Column(name = "name")
    val itemName: String,

    @Column(name = "is_in_collection", nullable = true)
    val isInCollection: Int?,

    @Column(name = "format", nullable = true)
    val formatId: Int?,

    @Column(name = "platform", nullable = true)
    val platform: String?,

    @Column(name = "description")
    val description: String,

    @Column(name = "user_comment", nullable = true)
    val userComment: String?,

    @Column(name = "ext_link", nullable = true)
    val externalLink: String?,

    @Column(name = "quantity", nullable = true)
    val quantity: Int?,

    @Column(name = "artist", nullable = true)
    val artist: String?,

    @Column(name = "released", nullable = true)
    val releaseYear: Int?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null
)