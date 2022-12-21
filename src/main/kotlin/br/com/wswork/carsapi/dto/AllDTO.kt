package br.com.wswork.carsapi.dto

import br.com.wswork.carsapi.entity.Brand
import br.com.wswork.carsapi.entity.Car
import br.com.wswork.carsapi.entity.Model
import java.util.*

class AllDTO(
    var idBrand: Long? = null,
    var nameBrand: String? = null,
    var idModel: Long? = null,
    var nameModel: String? = null,
    var fipeValue: Float? = null,
    var idCar: Long? = null,
    var created: Date? = Date(),
    var year: Int? = null,
    var door: Int? = null,
    var color: String? = null,
    var fuel: String? = null
) {
    constructor(brand: Brand, model: Model, car: Car) : this() {
        idBrand = brand.id
        nameBrand = brand.name
        idModel = model.id
        nameModel = model.name
        fipeValue = model.fipeValue
        idCar = car.id
        created = car.created
        year = car.year
        door = car.door
        color = car.color
        fuel = car.fuel
    }
}