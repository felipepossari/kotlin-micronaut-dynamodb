package com.felipepossari.dynamodb.adapter.out.dynamo

import com.felipepossari.dynamodb.adapter.out.dynamo.model.MotorcycleCompositeKey
import com.felipepossari.dynamodb.adapter.out.dynamo.model.MotorcycleEntity
import com.felipepossari.dynamodb.adapter.out.dynamo.model.toDomain
import com.felipepossari.dynamodb.adapter.out.dynamo.model.toKey
import com.felipepossari.dynamodb.application.domain.Motorcycle
import com.felipepossari.dynamodb.application.port.out.MotorcycleRepositoryPort
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import java.util.*
import javax.inject.Singleton

@Singleton
class MotorcycleRepository : MotorcycleRepositoryPort {

    private val motorcycleTable: DynamoDbTable<MotorcycleEntity>

    constructor(dynamoDbClientEnhancedClient: DynamoDbEnhancedClient) {
        motorcycleTable = dynamoDbClientEnhancedClient
                .table(TABLE_NAME, TableSchema.fromClass(MotorcycleEntity::class.java))
    }

    override fun save(email: String, motorcycle: Motorcycle): Motorcycle {
        val bike = fillId(motorcycle)
        val key = MotorcycleCompositeKey(email, bike.id)
        val bikeEntity = MotorcycleEntity(key, bike)
        motorcycleTable.putItem(bikeEntity)
        return bikeEntity.toDomain()
    }

    override fun findById(email: String, motorcycleId: String): Motorcycle? {
        val compositeKey = MotorcycleCompositeKey(email, motorcycleId).toKey()
        return motorcycleTable.getItem(compositeKey)?.toDomain()
    }

    override fun update(email: String, motorcycle: Motorcycle): Motorcycle {
        val compositeKey = MotorcycleCompositeKey(email, motorcycle.id)
        return motorcycleTable.updateItem(MotorcycleEntity(compositeKey, motorcycle)).toDomain()
    }

    private fun fillId(motorcycle: Motorcycle): Motorcycle =
            motorcycle.copy(id = UUID.randomUUID().toString())
}