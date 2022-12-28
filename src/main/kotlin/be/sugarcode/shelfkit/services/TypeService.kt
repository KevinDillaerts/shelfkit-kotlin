package be.sugarcode.shelfkit.services

import be.sugarcode.shelfkit.repositories.items.Type
import be.sugarcode.shelfkit.repositories.types.TypeRepository
import be.sugarcode.shelfkit.services.dtos.CreateTypeDTO
import be.sugarcode.shelfkit.services.mappers.TypeMapper
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class TypeService(val typeRepository: TypeRepository, val typeMapper: TypeMapper) {
    fun addNewType(createTypeDTO: CreateTypeDTO): Type {
        return typeRepository.save(typeMapper.typeDTOtoType(createTypeDTO))
    }
}