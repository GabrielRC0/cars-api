package br.com.wswork.carsapi.util

import br.com.wswork.carsapi.dto.BrandDTO
import br.com.wswork.carsapi.entity.Brand

object DtoConverter {
    fun brandEntityToDto(entity: Brand): BrandDTO {
        val dto = BrandDTO()
        dto.id = entity.id
        dto.name = entity.name
        return dto
    }

    fun brandDtoToEntity(dto: BrandDTO): Brand {
        val entity = Brand()
        entity.id = dto.id
        entity.name = dto.name
        return entity
    }
}

