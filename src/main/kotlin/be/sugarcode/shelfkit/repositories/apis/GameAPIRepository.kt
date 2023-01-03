package be.sugarcode.shelfkit.repositories.apis

import org.springframework.data.jpa.repository.JpaRepository

interface GameAPIRepository : JpaRepository<GameAPIKeys, String> {
}