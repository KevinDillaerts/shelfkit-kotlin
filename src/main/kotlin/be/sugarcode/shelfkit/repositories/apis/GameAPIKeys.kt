package be.sugarcode.shelfkit.repositories.apis

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "apikey")
class GameAPIKeys(
    @Column(name = "access_token")
    var accessToken: String,

    @Column(name = "expires_in")
    var expiresIn: Long,

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime,

    @Column(name = "token_type")
    val tokenType: String,

    @Id
    @Column(name = "name")
    val name: String
)