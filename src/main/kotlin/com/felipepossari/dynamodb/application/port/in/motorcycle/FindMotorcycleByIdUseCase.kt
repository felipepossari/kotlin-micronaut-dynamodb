package com.felipepossari.dynamodb.application.port.`in`.motorcycle

import com.felipepossari.dynamodb.application.domain.Motorcycle

interface FindMotorcycleByIdUseCase {

    fun execute(email: String, motorcycleId: String): Motorcycle
}