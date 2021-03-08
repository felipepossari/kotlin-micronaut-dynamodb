package com.felipepossari.dynamodb.application.port.out

import com.felipepossari.dynamodb.application.domain.Motorcycle

interface MotorcycleRepositoryPort {

    fun save(email: String, motorcycle: Motorcycle): Motorcycle

    fun findById(email: String, motorcycleId: String): Motorcycle?

    fun findAllByEmail(email: String): List<Motorcycle>

    fun update(email: String, motorcycle: Motorcycle): Motorcycle

    fun delete(email: String, motorcycle: Motorcycle)
}