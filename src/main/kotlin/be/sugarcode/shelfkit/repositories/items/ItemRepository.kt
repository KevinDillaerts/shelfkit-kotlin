package be.sugarcode.shelfkit.repositories.items

import be.sugarcode.shelfkit.repositories.users.User
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Int> {
    fun findAllByUser(user: User): List<Item>

    fun findAllByUserAndType(user: User, type: Type): List<Item>
}