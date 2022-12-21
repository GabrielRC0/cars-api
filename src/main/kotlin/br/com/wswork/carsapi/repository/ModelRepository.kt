package br.com.wswork.carsapi.repository

import br.com.wswork.carsapi.entity.Model
import org.springframework.data.jpa.repository.JpaRepository

interface ModelRepository: JpaRepository<Model,Long>