package br.com.wswork.carsapi.repository

import br.com.wswork.carsapi.entity.Brand
import org.springframework.data.jpa.repository.JpaRepository

interface BrandRepository: JpaRepository<Brand, Long> {
}