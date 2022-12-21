package br.com.wswork.carsapi.service

import br.com.wswork.carsapi.dto.BrandDTO
import br.com.wswork.carsapi.entity.Brand
import br.com.wswork.carsapi.repository.BrandRepository
import br.com.wswork.carsapi.util.DtoConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service
import java.net.http.HttpResponse

@Service
class BrandService {

    @Autowired
    lateinit var repository: BrandRepository

    fun getAll(): List<BrandDTO> {
        val brandList = repository.findAll()
        if (brandList.isEmpty()) {
            throw Exception("No registered brands")
        }
        val brandDTOlist = mutableListOf<BrandDTO>()
        brandList.forEach { _brand ->
            val brandDto = DtoConverter.brandEntityToDto(_brand)
            brandDTOlist.add(brandDto)
        }
        return brandDTOlist
    }

    fun verifyOne(id: Long) {
        val wasFound = repository.existsById(id)

        if (!wasFound) {
            throw Exception("Not found brand id $id")
        }
    }

    fun findBrand(id: Long): Brand {
        return repository.findById(id).orElseThrow { Exception("Not found brand id $id") }
    }

    fun findBrandId(id: Long): BrandDTO {
        val brandIdFound = repository.findById(id).orElseThrow { Exception("Not found brand id $id") }
        val brandDto = DtoConverter.brandEntityToDto(brandIdFound)
        return (brandDto)
    }

    fun createBrand(data: BrandDTO): Brand {
        data.id = null
        val newBrand = DtoConverter.brandDtoToEntity(data)
        return repository.save(newBrand)
    }

    //
    fun update(id: Long, data: BrandDTO): Brand {
        val brandFound = findBrand(id)
        brandFound.name = data.name
        return repository.save(brandFound)
    }

    fun delete(id: Long) {
        val wasFound = repository.existsById(id)

        if (!wasFound) {
            throw Exception("Not found brand id $id")
        }
        repository.deleteById(id)
    }
}
