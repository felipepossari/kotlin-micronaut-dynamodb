package com.felipepossari.dynamodb.application.port.`in`.motorcycle

import com.felipepossari.dynamodb.application.domain.Motorcycle

interface CreateMotorcycleUseCase {

    fun execute(email: String, motorcycle: Motorcycle): Motorcycle
}