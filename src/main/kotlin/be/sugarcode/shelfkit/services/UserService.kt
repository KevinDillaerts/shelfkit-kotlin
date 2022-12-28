package be.sugarcode.shelfkit.services

import be.sugarcode.shelfkit.repositories.users.User
import be.sugarcode.shelfkit.repositories.users.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class UserService(val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun addUser(user: User): User {
        return userRepository.save(user)
    }
}