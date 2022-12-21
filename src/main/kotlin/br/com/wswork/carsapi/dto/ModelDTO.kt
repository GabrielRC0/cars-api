package br.com.wswork.carsapi.dto

import br.com.wswork.carsapi.entity.Model

class ModelDTO(
    var id: Long? = null,
    var name: String? = null,
    var fipeValue: Float? = null,
    var brandId: Long? = null,
) {
    constructor(model: Model) : this() {
        id = model.id
        name = model.name
        fipeValue = model.fipeValue
        brandId = model.brand?.id
    }
}