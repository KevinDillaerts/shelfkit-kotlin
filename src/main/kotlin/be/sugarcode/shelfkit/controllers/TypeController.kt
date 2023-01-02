package be.sugarcode.shelfkit.controllers

import be.sugarcode.shelfkit.repositories.items.Type
import be.sugarcode.shelfkit.services.TypeService
import be.sugarcode.shelfkit.services.dtos.CreateTypeDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/types")
class TypeController(val typeService: TypeService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addNewType(@RequestBody createTypeDTO: CreateTypeDTO): Type {
        return typeService.addNewType(createTypeDTO)
    }
}