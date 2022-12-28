package be.sugarcode.shelfkit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShelfkitApplication

fun main(args: Array<String>) {
    runApplication<ShelfkitApplication>(*args)
}
