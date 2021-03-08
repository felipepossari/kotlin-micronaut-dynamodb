package com.felipepossari.dynamodb.application.service.motorcycle

import com.felipepossari.dynamodb.application.domain.Motorcycle
import com.felipepossari.dynamodb.application.exception.ResourceNotFoundException
import com.felipepossari.dynamodb.application.exception.model.ErrorReason
import com.felipepossari.dynamodb.application.port.`in`.motorcycle.DeleteMotorcycleUseCase
import com.felipepossari.dynamodb.application.port.out.MotorcycleRepositoryPort
import javax.inject.Singleton

@Singleton
class DeleteMotorcycleService(
        private val motorcycleRepositoryPort: MotorcycleRepositoryPort
) : DeleteMotorcycleUseCase {
    override fun execute(email: String, motorcycleId: String) {
        val bike = retrieveMotorcycle(email, motorcycleId)
        motorcycleRepositoryPort.delete(email, bike)
    }

    private fun retrieveMotorcycle(email: String, motorcycleId: String): Motorcycle =
            motorcycleRepositoryPort.findById(email, motorcycleId)
                    ?: throw ResourceNotFoundException(ErrorReason.RESOURCE_NOT_FOUND)
}