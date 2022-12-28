package be.sugarcode.shelfkit.repositories.types

import be.sugarcode.shelfkit.repositories.items.Type
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TypeRepository : JpaRepository<Type, Int> {
    fun findTypeByTypeNameEqualsIgnoreCase(typeName: String): Optional<Type>
}