package br.com.wswork.carsapi.dto

import br.com.wswork.carsapi.entity.Car
import br.com.wswork.carsapi.entity.Model
import java.util.Date

class CarDTO(
    var id: Long? = null,
    var created: Date? = Date(),
    var model_id: Long? = null,
    var year: Int? = null,
    var door: Int? = null,
    var color: String? = null,
    var fuel: String? = null
) {
    constructor(car: Car) : this() {
        id = car.id
        created = car.created
        model_id = car.modelId?.id
        year = car.year
        door = car.door
        color = car.color
        fuel = car.fuel
    }
}