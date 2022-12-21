package br.com.wswork.carsapi.controller

import br.com.wswork.carsapi.dto.AllDTO
import br.com.wswork.carsapi.dto.CarDTO
import br.com.wswork.carsapi.service.CarService
import br.com.wswork.carsapi.util.DtoConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

//@CrossOrigin(allowedHeaders =["*"], origins =["*"], exposedHeaders = ["*"])
@RestController
@CrossOrigin
@RequestMapping("/car")
class CarController {
    @Autowired
    lateinit var service: CarService


    @GetMapping("/get")
    fun findAll(): ResponseEntity<List<CarDTO>> {
        val serviceGetAll = service.getAll()
        val ok = HttpStatus.OK
        return ResponseEntity(serviceGetAll, ok)
    }

    @GetMapping("/all")
    fun findAllCarsInfo(): ResponseEntity<List<AllDTO>> {
        val serviceGetAllInfo = service.getAllCarsInfo()
        val ok = HttpStatus.OK
        return ResponseEntity(serviceGetAllInfo, ok)
    }

    @GetMapping("/get/{id}")
    fun get(@PathVariable id: Long): CarDTO {
        val serviceGetCarId = service.findCarId(id)
        val ok = HttpStatus.OK
        return (serviceGetCarId)
    }

    @PostMapping("/post")
    fun create(@RequestBody data: CarDTO): ResponseEntity<CarDTO> {
        val carSaved = service.createCar(data)
        val result = DtoConverter.carEntityToDto(carSaved)
        val created = HttpStatus.CREATED
        return ResponseEntity(result, created)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody data: CarDTO):
            ResponseEntity<CarDTO> {
        val carUpdated = service.update(id, data)
        val result = CarDTO(car = carUpdated)

        return ResponseEntity(result, HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}

