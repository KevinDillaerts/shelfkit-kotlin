package be.sugarcode.shelfkit.controllers

import be.sugarcode.shelfkit.repositories.users.User
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.apache.http.HttpStatus
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserControllerTest {

    @LocalServerPort
    var port = 7000

    @Test
    fun `Save new user`() {
        val testUser = User(6)

        val createdUser: User =
            Given {
                port(port)
                contentType(MediaType.APPLICATION_JSON_VALUE)
                body(testUser)
            } When {
                post("/users")
            } Then {
                statusCode(HttpStatus.SC_CREATED)
                log().all()
            } Extract {
                `as`(User::class.java)
            }

        Assertions.assertEquals(testUser.extUserId, createdUser.extUserId)
    }
}