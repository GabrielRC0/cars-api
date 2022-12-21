package br.com.wswork.carsapi.service

import br.com.wswork.carsapi.dto.ModelDTO
import br.com.wswork.carsapi.entity.Brand
import br.com.wswork.carsapi.entity.Model
import br.com.wswork.carsapi.repository.ModelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ModelService {
    @Autowired
    lateinit var repository: ModelRepository

    @Autowired
    lateinit var brandService: BrandService

    fun getAll(): List<ModelDTO> {
        val modelList = repository.findAll()
        if (modelList.isEmpty()) {
            throw Exception("No registered models")
        }
        val modelDTOlist = mutableListOf<ModelDTO>()
        modelList.forEach { _model ->
            val modelDto = ModelDTO(_model)
            modelDTOlist.add(modelDto)
        }
        return modelDTOlist
    }

    fun verifyOne(id: Long) {
        val wasFound = repository.existsById(id)

        if (!wasFound) {
            throw Exception("Not found model id:$id")
        }
    }

    fun findModel(id: Long): Model {
        return repository.findById(id).orElseThrow { Exception("Not found model id: $id") }
    }

    fun findModelId(id: Long): ModelDTO {
        val modelIdFound = repository.findById(id).orElseThrow { Exception("Not found model id $id") }
        val modelDto = ModelDTO(modelIdFound)
        return (modelDto)
    }

    fun createModel(data: ModelDTO): Model {
        if (data.brandId != null) {
            val newBrand = brandService.findBrand(data.brandId!!)
            val newModel = Model().apply {
                this.brand = newBrand
                this.fipeValue = data.fipeValue
                this.name = data.name
            }
            return repository.save(newModel)
        } else {
            throw Exception("Brand id cannot be null!")
        }

    }

    fun update(id: Long, data: ModelDTO): Model {
        val modelFound = findModel(id)
        modelFound.name = data.name
        return repository.save(modelFound)
    }

    fun delete(id: Long) {
        val wasFound = repository.existsById(id)

        if (!wasFound) {
            throw Exception("Not found model id $id")
        }
        repository.deleteById(id)
    }

}