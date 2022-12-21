package br.com.wswork.carsapi.controller

import br.com.wswork.carsapi.dto.BrandDTO
import br.com.wswork.carsapi.dto.CarDTO
import br.com.wswork.carsapi.entity.Brand
import br.com.wswork.carsapi.service.BrandService
import br.com.wswork.carsapi.util.DtoConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
@RequestMapping("/brand")
class BrandController {
    @Autowired
    lateinit var service: BrandService


    @GetMapping("/get")
    fun findAll(): ResponseEntity<List<BrandDTO>> {
        val serviceGetAll = service.getAll()
        val ok = HttpStatus.OK
        return ResponseEntity(serviceGetAll, ok)
    }

    @GetMapping("/get/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<BrandDTO> {
        val serviceGetBrandId = service.findBrandId(id)
        val ok = HttpStatus.OK
        return ResponseEntity(serviceGetBrandId, ok)
    }

    @PostMapping("/post")
    fun create(@RequestBody data: BrandDTO): ResponseEntity<BrandDTO> {
        val brandSaved = service.createBrand(data)
        val result = DtoConverter.brandEntityToDto(brandSaved)
        val created = HttpStatus.CREATED
        return ResponseEntity(result, created)
    }

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody data: BrandDTO):
            ResponseEntity<BrandDTO> {
        val brandUpdated = service.update(id, data)
        val result = DtoConverter.brandEntityToDto(brandUpdated)
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