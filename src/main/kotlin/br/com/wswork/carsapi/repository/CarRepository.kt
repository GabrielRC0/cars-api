package br.com.wswork.carsapi.repository

import br.com.wswork.carsapi.entity.Car
import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository:JpaRepository<Car, Long> {
    }