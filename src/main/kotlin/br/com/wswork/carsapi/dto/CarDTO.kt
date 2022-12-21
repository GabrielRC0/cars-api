package br.com.wswork.carsapi.dto

import br.com.wswork.carsapi.entity.Cars
import br.com.wswork.carsapi.entity.Model

class CarDTO(
    var id: Long? = null,
    var created: String? = null,
    var model: Model? = null,
    var year: Int? = null,
    var door: Int? = null,
    var color: String? = null
) {
    constructor(cars: Cars) : this() {
        id = cars.id
        created = cars.created.toString()
        model = cars.model
        year = cars.year
        door = cars.door
        color = cars.color
    }
}