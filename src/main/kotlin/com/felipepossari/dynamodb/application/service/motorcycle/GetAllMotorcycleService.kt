package com.felipepossari.dynamodb.application.service.motorcycle

import com.felipepossari.dynamodb.application.domain.Motorcycle
import com.felipepossari.dynamodb.application.port.`in`.motorcycle.GetAllMotorcycleUseCase
import com.felipepossari.dynamodb.application.port.out.MotorcycleRepositoryPort
import javax.inject.Singleton

@Singleton
class GetAllMotorcycleService(
        private val motorcycleRepositoryPort: MotorcycleRepositoryPort
) : GetAllMotorcycleUseCase {
    override fun execute(email: String): List<Motorcycle> =  motorcycleRepositoryPort.findAllByEmail(email)

}