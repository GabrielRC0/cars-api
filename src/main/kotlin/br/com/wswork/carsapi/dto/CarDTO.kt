package br.com.wswork.carsapi.dto

import br.com.wswork.carsapi.entity.Car
import br.com.wswork.carsapi.entity.Model
import java.util.Date

class CarDTO(
    var id: Long? = null,
    var created: Date? = null,
    var model: Model? = null,
    var year: Int? = null,
    var door: Int? = null,
    var color: String? = null,
    var fuel: String? = null
) {
    constructor(car: Car) : this() {
        id = car.id
        created = car.created
        model = car.model
        year = car.year
        door = car.door
        color = car.color
        fuel = car.fuel
    }
}