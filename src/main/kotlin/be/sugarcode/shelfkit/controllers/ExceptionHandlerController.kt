package be.sugarcode.shelfkit.controllers

import be.sugarcode.shelfkit.exceptions.ErrorMessageModel
import be.sugarcode.shelfkit.exceptions.KeyNotFoundException
import be.sugarcode.shelfkit.exceptions.TypeNotFoundException
import be.sugarcode.shelfkit.exceptions.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandlerController : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [UserNotFoundException::class, TypeNotFoundException::class, KeyNotFoundException::class])
    fun handleArticleNotFoundException(ex: RuntimeException): ResponseEntity<ErrorMessageModel> {

        val errorMessage = ErrorMessageModel(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }
}