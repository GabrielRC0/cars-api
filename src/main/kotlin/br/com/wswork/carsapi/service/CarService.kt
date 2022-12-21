package br.com.wswork.carsapi.service

import br.com.wswork.carsapi.dto.AllDTO
import br.com.wswork.carsapi.dto.CarDTO
import br.com.wswork.carsapi.entity.Car
import br.com.wswork.carsapi.entity.Model
import br.com.wswork.carsapi.repository.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service

@Service
class CarService {

    @Autowired
    lateinit var repository: CarRepository

    @Autowired
    lateinit var modelService: ModelService

    fun getAll(): List<CarDTO> {
        val carList = repository.findAll()
        if (carList.isEmpty()) {
            throw ChangeSetPersister.NotFoundException()
        }

        val carDTOlist = ArrayList<CarDTO>()



        carList.forEach { _car ->
            val carDto = CarDTO()
            carDto.id = _car.id
            carDto.created = _car.created
            carDto.model_id = _car.modelId?.id
            carDto.year = _car.year
            carDto.door = _car.door
            carDto.color = _car.color
            carDTOlist.add(carDto)

        }


        return carDTOlist
    }

    fun verifyOne(id: Long) {
        val wasFound = repository.existsById(id)

        if (!wasFound) {
            throw ChangeSetPersister.NotFoundException()
        }

    }

    fun findCar(id: Long): Car {
        return repository.findById(id).orElseThrow { ChangeSetPersister.NotFoundException() }
    }


    fun findCarId(id: Long): CarDTO {
        val carIdFound = repository.findById(id).orElseThrow { ChangeSetPersister.NotFoundException() }
        val carIdDto = CarDTO()
        carIdDto.id = carIdFound.id!!
        carIdDto.created = carIdFound.created
        carIdDto.model_id = carIdFound.modelId?.id
        carIdDto.year = carIdFound.year
        carIdDto.door = carIdFound.door
        carIdDto.color = carIdFound.color
        return (carIdDto)
    }

    fun findAllById(ids: List<Long>): List<Car> {
        val carList = repository.findAllById(ids)
        val idsFound = carList.map { it.id }

        ids.forEach {
            val wasFound = idsFound.contains(it)

            if (!wasFound) {
                throw ChangeSetPersister.NotFoundException()
            }
        }
        return carList
    }

    fun createCar(data: CarDTO): Car {
        if (data.model_id != null) {
            val newModel = modelService.findModel(data.model_id!!)
            val newCar = Car().apply {
                this.year = data.year
                this.door = data.door
                this.color = data.color
                this.created = data.created
                this.modelId = newModel
            }
            return repository.save(newCar)
        } else {
            throw Exception("Model id cannot be null!")
        }
    }

//

    fun update(id: Long, data: CarDTO): Car {
        val companyFound = findCar(id)

        companyFound.apply {
            this.id = data.id
            this.year = data.year
            this.door = data.door
            this.color = data.color
            this.modelId = this.modelId
        }
        return repository.save(companyFound)
    }

    fun delete(id: Long) {
        val wasFound = repository.existsById(id)

        if (!wasFound) {
            throw ChangeSetPersister.NotFoundException()
        }
        repository.deleteById(id)
    }


    fun getAllCarsInfo(): List<AllDTO> {
        val allList = repository.findAll()
        if (allList.isEmpty()) {
            throw ChangeSetPersister.NotFoundException()
        }

        val allDTOlist = ArrayList<AllDTO>()



        allList.forEach { _all ->
            val allDto = AllDTO()
            allDto.idBrand = _all.modelId?.brand?.id
            allDto.created = _all.created
            allDto.nameBrand = _all.modelId?.brand?.name
            allDto.idModel = _all.modelId?.id
            allDto.nameModel = _all.modelId?.name
            allDto.fipeValue = _all.modelId?.fipeValue
            allDto.idCar = _all.id
            allDto.year = _all.year
            allDto.door = _all.door
            allDto.color = _all.color
            allDto.fuel = _all.fuel
            allDTOlist.add(allDto)
        }


        return allDTOlist
    }
}

