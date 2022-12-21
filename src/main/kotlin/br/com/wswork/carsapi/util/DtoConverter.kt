package br.com.wswork.carsapi.util

import br.com.wswork.carsapi.dto.BrandDTO
import br.com.wswork.carsapi.dto.CarDTO
import br.com.wswork.carsapi.entity.Brand
import br.com.wswork.carsapi.entity.Car
import java.util.*

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

    fun carEntityToDto(entity: Car): CarDTO {
        val dto = CarDTO()
        dto.id = entity.id
        dto.created = Date()
        dto.model_id= entity.modelId?.id
        dto.door = entity.door
        dto.color = entity.color
        dto.fuel = entity.fuel
        dto.year = entity.year
        return dto
    }

}

