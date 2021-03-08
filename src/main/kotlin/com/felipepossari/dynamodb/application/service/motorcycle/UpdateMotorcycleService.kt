package com.felipepossari.dynamodb.application.service.motorcycle

import com.felipepossari.dynamodb.application.domain.Motorcycle
import com.felipepossari.dynamodb.application.exception.ResourceNotFoundException
import com.felipepossari.dynamodb.application.exception.model.ErrorReason
import com.felipepossari.dynamodb.application.port.`in`.motorcycle.UpdateMotorcycleUseCase
import com.felipepossari.dynamodb.application.port.out.MotorcycleRepositoryPort
import javax.inject.Singleton

@Singleton
class UpdateMotorcycleService(
        private val motorcycleRepositoryPort: MotorcycleRepositoryPort
) : UpdateMotorcycleUseCase {
    override fun execute(email: String, motorcycle: Motorcycle): Motorcycle {
        motorcycle.validateFieldsForUpdate()
        val bike = retrieveMotorcycle(email, motorcycle.id)
        return update(email, bike, motorcycle)
    }

    private fun update(email: String, actualMotorcycle: Motorcycle, motorcycle: Motorcycle): Motorcycle {
        val updateBike = actualMotorcycle.copy(
                id = motorcycle.id,
                brand = motorcycle.brand,
                model = motorcycle.model,
                manufactureYear = motorcycle.manufactureYear,
                modelYear = motorcycle.modelYear,
                color = motorcycle.color
        )
        return motorcycleRepositoryPort.update(email, updateBike)
    }

    private fun retrieveMotorcycle(email: String, motorcycleId: String): Motorcycle =
            motorcycleRepositoryPort.findById(email, motorcycleId)
                    ?: throw ResourceNotFoundException(ErrorReason.RESOURCE_NOT_FOUND)


}