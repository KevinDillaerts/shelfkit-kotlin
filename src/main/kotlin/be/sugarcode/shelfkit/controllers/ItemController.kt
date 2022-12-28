package be.sugarcode.shelfkit.controllers

import be.sugarcode.shelfkit.services.ItemService
import be.sugarcode.shelfkit.services.dtos.CreateItemDTO
import be.sugarcode.shelfkit.services.dtos.ItemDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/item")
class ItemController(val itemService: ItemService) {
    @GetMapping("/{id}")
    fun getAllItemsByUser(@PathVariable id: Int, @RequestParam(required = false) types: Array<String>?): List<ItemDTO> {
        if (types.isNullOrEmpty()) {
            return itemService.getAllItemsByUser(id)
        }
        return itemService.getAllItemsByUserAndType(id, types)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addNewItem(@RequestBody createItemDTO: CreateItemDTO): ItemDTO {
        return itemService.addNewItem(createItemDTO)
    }
}