package com.felipepossari.dynamodb.application.service.motorcycle

import com.felipepossari.dynamodb.application.domain.Motorcycle
import com.felipepossari.dynamodb.application.exception.ResourceNotFoundException
import com.felipepossari.dynamodb.application.exception.model.ErrorReason
import com.felipepossari.dynamodb.application.port.`in`.motorcycle.FindMotorcycleByIdUseCase
import com.felipepossari.dynamodb.application.port.out.MotorcycleRepositoryPort
import javax.inject.Singleton

@Singleton
class FindMotorcycleByIdService(
        private val motorcycleRepositoryPort: MotorcycleRepositoryPort
) : FindMotorcycleByIdUseCase {
    override fun execute(email: String, motorcycleId: String): Motorcycle {
        return retrieveMotorcycle(email, motorcycleId)
    }

    private fun retrieveMotorcycle(email: String, motorcycleId: String): Motorcycle =
            motorcycleRepositoryPort.findById(email, motorcycleId)
                    ?: throw ResourceNotFoundException(ErrorReason.RESOURCE_NOT_FOUND)
}