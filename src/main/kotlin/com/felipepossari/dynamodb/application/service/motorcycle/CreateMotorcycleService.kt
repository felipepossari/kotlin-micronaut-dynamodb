package com.felipepossari.dynamodb.application.service.motorcycle

import com.felipepossari.dynamodb.application.domain.Motorcycle
import com.felipepossari.dynamodb.application.port.`in`.motorcycle.CreateMotorcycleUseCase
import com.felipepossari.dynamodb.application.port.out.MotorcycleRepositoryPort
import javax.inject.Singleton

@Singleton
class CreateMotorcycleService(
        private val motorcycleRepositoryPort: MotorcycleRepositoryPort
) : CreateMotorcycleUseCase {
    override fun execute(email: String, motorcycle: Motorcycle): Motorcycle {
        return motorcycleRepositoryPort.save(email, motorcycle)
    }
}