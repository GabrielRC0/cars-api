package br.com.wswork.carsapi.dto

import br.com.wswork.carsapi.entity.Brand

class BrandDTO(
     var id: Long? = null,
     var name: String? = null
) {
    constructor(brand: Brand) : this() {
        id = brand.id
        name = brand.name
    }
}
