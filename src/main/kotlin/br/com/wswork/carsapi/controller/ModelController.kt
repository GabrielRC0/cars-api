package br.com.wswork.carsapi.controller

import br.com.wswork.carsapi.dto.ModelDTO
import br.com.wswork.carsapi.service.ModelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
@RequestMapping("/model")
class ModelController {

    @Autowired
    lateinit var service: ModelService


    @GetMapping("/get")
    fun findAll(): ResponseEntity<List<ModelDTO>> {
        val serviceGetAll = service.getAll()
        val ok = HttpStatus.OK
        return ResponseEntity(serviceGetAll, ok)
    }

    @GetMapping("/get/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<ModelDTO> {
        val serviceGetModelId = service.findModelId(id)
        val ok = HttpStatus.OK
        return ResponseEntity(serviceGetModelId, ok)
    }

    @PostMapping("/post")
    fun create(@RequestBody data: ModelDTO): ResponseEntity<ModelDTO> {
        val modelSaved = service.createModel(data)
        val result = ModelDTO(modelSaved)
        val created = HttpStatus.CREATED
        return ResponseEntity(result, created)
    }

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody data: ModelDTO):
            ResponseEntity<ModelDTO> {
        val modelUpdated = service.update(id, data)
        val result = ModelDTO(modelUpdated)
        val updated = HttpStatus.OK
        return ResponseEntity(result, updated)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        val deleted = HttpStatus.NO_CONTENT
        return ResponseEntity(deleted)
    }
}