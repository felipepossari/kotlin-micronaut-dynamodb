package com.felipepossari.dynamodb.application.port.out

import com.felipepossari.dynamodb.application.domain.Motorcycle

interface MotorcycleRepositoryPort {

    fun save(email: String, motorcycle: Motorcycle): Motorcycle
}