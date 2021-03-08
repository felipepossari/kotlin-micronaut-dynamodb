package com.felipepossari.dynamodb.application.port.`in`.motorcycle

import com.felipepossari.dynamodb.application.domain.Motorcycle

interface UpdateMotorcycleUseCase {

    fun execute(email: String, motorcycle: Motorcycle): Motorcycle
}