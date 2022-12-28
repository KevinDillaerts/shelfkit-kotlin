package be.sugarcode.shelfkit.controllers

import be.sugarcode.shelfkit.repositories.users.User
import be.sugarcode.shelfkit.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {
    @GetMapping
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    @PostMapping
    fun addUser(@RequestBody user: User): User {
        return userService.addUser(user)
    }
}