package com.felipepossari.dynamodb.adapter.out.dynamo

import com.felipepossari.dynamodb.application.domain.Motorcycle
import com.felipepossari.dynamodb.application.port.out.MotorcycleRepositoryPort
import javax.inject.Singleton

@Singleton
class MotorcycleRepository : MotorcycleRepositoryPort {
    override fun save(motorcycle: Motorcycle): Motorcycle {
        TODO("Not yet implemented")
    }
}