package be.sugarcode.shelfkit.services

import be.sugarcode.shelfkit.exceptions.TypeNotFoundException
import be.sugarcode.shelfkit.exceptions.UserNotFoundException
import be.sugarcode.shelfkit.repositories.items.ItemRepository
import be.sugarcode.shelfkit.repositories.types.TypeRepository
import be.sugarcode.shelfkit.repositories.users.UserRepository
import be.sugarcode.shelfkit.services.dtos.CreateItemDTO
import be.sugarcode.shelfkit.services.dtos.ItemDTO
import be.sugarcode.shelfkit.services.mappers.ItemMapper
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class ItemService(
    val itemRepository: ItemRepository, val userRepository: UserRepository,
    val itemMapper: ItemMapper, val typeRepository: TypeRepository
) {
    fun getAllItemsByUser(id: Int): List<ItemDTO> {
        val foundUser = userRepository.findById(id).orElseThrow { UserNotFoundException() }

        return itemRepository.findAllByUser(foundUser)
            .map { itemMapper.itemToItemDTO(it) }
            .toList()
    }

    fun getAllItemsByUserAndType(userId: Int, types: Array<String>): List<ItemDTO> {
        val unfilteredItems = getAllItemsByUser(userId)
        return unfilteredItems.filter { itemDTO -> types.contains(itemDTO.type.lowercase()) }
    }

    fun addNewItem(createItemDTO: CreateItemDTO): ItemDTO {
        val foundUser = userRepository.findById(createItemDTO.userId).orElseThrow { UserNotFoundException() }
        val foundType = typeRepository.findById(createItemDTO.typeId).orElseThrow { TypeNotFoundException() }
        val newItem = itemMapper.createItemDTOToItem(createItemDTO, foundType, foundUser)
        return itemMapper.itemToItemDTO(itemRepository.save(newItem))
    }
}