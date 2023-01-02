package be.sugarcode.shelfkit.controllers

import be.sugarcode.shelfkit.repositories.users.User
import be.sugarcode.shelfkit.services.dtos.CreateItemDTO
import be.sugarcode.shelfkit.services.dtos.CreateTypeDTO
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.apache.http.HttpStatus
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ItemControllerTest() {

    @LocalServerPort
    var port: Int = 7001

    @BeforeEach
    fun setUp() {
        val testUser = User(6, 1)

        Given {
            port(port)
            contentType(MediaType.APPLICATION_JSON_VALUE)
            body(testUser)
        } When {
            post("/users")
        } Then {
            statusCode(HttpStatus.SC_CREATED)
            log().all()
        }

        val testType = CreateTypeDTO(
            "type", null, "item", "image", null, null,
            null, null, null, null, "description", null, null
        )

        Given {
            port(port)
            contentType(MediaType.APPLICATION_JSON_VALUE)
            body(testType)
        } When {
            post("/types")
        } Then {
            statusCode(HttpStatus.SC_CREATED)
            log().all()
        }

    }

    @Test
    fun `add new item`() {
        val testItem = CreateItemDTO(
            1, 1, "image", "testItem",
            1, 1, "PlayStation 5", "Description", null, null,
            null, "Kevin Dillaerts", 2022
        )

        Given {
            port(port)
            contentType(MediaType.APPLICATION_JSON_VALUE)
            body(testItem)
        } When {
            post("/items")
        } Then {
            statusCode(HttpStatus.SC_CREATED)
            log().all()
        }
    }

}

