package br.com.wswork.carsapi.repository

import br.com.wswork.carsapi.entity.Cars
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CarRepository:JpaRepository<Cars, Long> {
    }