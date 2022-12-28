package be.sugarcode.shelfkit.repositories.users

import jakarta.persistence.*

@Entity
@Table(name = "user")
class User(
    @Column(name = "ext_user_id")
    val extUserId: Int,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null
)