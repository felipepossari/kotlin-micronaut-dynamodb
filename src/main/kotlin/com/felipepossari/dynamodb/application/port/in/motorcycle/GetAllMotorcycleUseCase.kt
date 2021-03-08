package com.felipepossari.dynamodb.application.port.`in`.motorcycle

import com.felipepossari.dynamodb.application.domain.Motorcycle

interface GetAllMotorcycleUseCase {

    fun execute(email: String): List<Motorcycle>
}