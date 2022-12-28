package be.sugarcode.shelfkit.services.mappers

import be.sugarcode.shelfkit.repositories.items.Type
import be.sugarcode.shelfkit.services.dtos.CreateTypeDTO
import org.springframework.stereotype.Component

@Component
class TypeMapper {

    fun typeDTOtoType(createTypeDTO: CreateTypeDTO): Type {
        return Type(
            typeName = createTypeDTO.typeName,
            isPredefined = null,
            itemName = createTypeDTO.itemName,
            image = createTypeDTO.image,
            artist = createTypeDTO.artist,
            releaseYear = createTypeDTO.releaseYear,
            formatId = createTypeDTO.formatId,
            platform = createTypeDTO.platform,
            isInCollection = createTypeDTO.isInCollection,
            quantity = createTypeDTO.quantity,
            description = createTypeDTO.description,
            userComment = createTypeDTO.userComment,
            externalLink = createTypeDTO.externalLink
        )
    }
}