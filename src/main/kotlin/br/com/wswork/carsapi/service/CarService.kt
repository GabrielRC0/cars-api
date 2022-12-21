package br.com.wswork.carsapi.service

import br.com.wswork.carsapi.dto.CarDTO
import br.com.wswork.carsapi.entity.Cars
import br.com.wswork.carsapi.repository.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service

@Service
class CarService {

    @Autowired
    lateinit var repository: CarRepository

    fun getAll(): List<CarDTO> {
        val carList = repository.findAll()
        if (carList.isEmpty()) {
            throw ChangeSetPersister.NotFoundException()
        }

        val carDTOlist = ArrayList<CarDTO>()



        carList.forEach { _car ->
            val carDto = CarDTO()
            carDto.id = _car.id
            carDto.created = _car.created.toString()
            carDto.model = _car.model
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

    fun findCar(id: Long): Cars {
        return repository.findById(id).orElseThrow { ChangeSetPersister.NotFoundException() }
    }


    fun findCarId(id: Long): CarDTO {
        val carIdFound = repository.findById(id).orElseThrow { ChangeSetPersister.NotFoundException() }
        val carIdDto = CarDTO()
        carIdDto.id = carIdFound.id!!
        carIdDto.created = carIdFound.created.toString()
        carIdDto.model = carIdFound.model
        carIdDto.year = carIdFound.year
        carIdDto.door = carIdFound.door
        carIdDto.color = carIdFound.color
        return (carIdDto)
    }

    fun findAllById(ids: List<Long>): List<Cars> {
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

    fun createCar(data: CarDTO): Cars {
        val newCar = Cars().apply {
            this.model = data.model
            this.year = data.year
            this.door = data.door
            this.color = data.color
        }
        return repository.save(newCar)
    }

//

    fun update(id: Long, data: CarDTO): Cars {
        val companyFound = findCar(id)

        companyFound.apply {
            this.id = id
            this.model = data.model
            this.year = data.year
            this.door = data.door
            this.color = data.color
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
}

