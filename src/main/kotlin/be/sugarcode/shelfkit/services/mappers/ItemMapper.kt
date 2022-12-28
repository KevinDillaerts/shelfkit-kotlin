package be.sugarcode.shelfkit.services.mappers

import be.sugarcode.shelfkit.repositories.items.Item
import be.sugarcode.shelfkit.repositories.items.Type
import be.sugarcode.shelfkit.repositories.users.User
import be.sugarcode.shelfkit.services.dtos.CreateItemDTO
import be.sugarcode.shelfkit.services.dtos.ItemDTO
import org.springframework.stereotype.Component

@Component
class ItemMapper {
    fun itemToItemDTO(item: Item): ItemDTO {
        return ItemDTO(
            itemId = item.id,
            type = item.type.typeName,
            user = item.user.id ?: -1,
            imageLink = item.imageLink,
            itemName = item.itemName,
            isInCollection = item.isInCollection,
            formatId = item.formatId,
            platform = item.platform,
            description = item.description,
            userComment = item.userComment,
            externalLink = item.externalLink,
            quantity = item.quantity,
            artist = item.artist,
            releaseYear = item.releaseYear
        )
    }

    fun createItemDTOToItem(createItemDTO: CreateItemDTO, type: Type, user: User): Item {
        return Item(
            type = type,
            user = user,
            imageLink = createItemDTO.imageLink,
            itemName = createItemDTO.itemName,
            isInCollection = createItemDTO.isInCollection,
            formatId = createItemDTO.formatId,
            platform = createItemDTO.platform,
            description = createItemDTO.description,
            userComment = createItemDTO.userComment,
            externalLink = createItemDTO.externalLink,
            quantity = createItemDTO.quantity,
            artist = createItemDTO.artist,
            releaseYear = createItemDTO.releaseYear
        )
    }
}