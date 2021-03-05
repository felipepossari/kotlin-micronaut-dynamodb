package com.felipepossari.dynamodb.application.service.motorcycle

import com.felipepossari.dynamodb.application.domain.Motorcycle
import com.felipepossari.dynamodb.application.port.`in`.motorcycle.CreateMotorcycleUseCase
import javax.inject.Singleton

@Singleton
class CreateMotorcycleService: CreateMotorcycleUseCase {
    override fun execute(motorcycle: Motorcycle): Motorcycle {
        TODO("Not yet implemented")
    }
}