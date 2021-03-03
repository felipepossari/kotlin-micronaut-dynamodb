package com.felipepossari.dynamodb.infrastructure.configuration

import com.felipepossari.dynamodb.adapter.out.dynamo.model.UserEntity
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Requires
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.ResourceInUseException
import java.net.URI
import javax.inject.Singleton

@Factory
@Requires(notEnv = ["production"])
class DynamoDbConfigLocal {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    @Singleton
    fun dynamoDbClient(): DynamoDbClient {
        return DynamoDbClient.builder()
                .region(Region.SA_EAST_1)
                .endpointOverride(URI.create("http://localhost:8000"))
                .build()
    }

    @Singleton
    fun dynamoDbClientEnhanced(): DynamoDbEnhancedClient {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient())
                .build()
    }

    @Singleton
    fun userTable(): DynamoDbTable<UserEntity> {
        val userTable = dynamoDbClientEnhanced()
                .table(UserEntity.TABLE_NAME, TableSchema.fromBean(UserEntity::class.java))
        createUserTable(userTable)
        return userTable
    }

    private fun createUserTable(table: DynamoDbTable<*>) {
        logger.info("--- Creating ${table.tableName()} table ---")
        try {
            table.createTable()
        }catch (e: ResourceInUseException){
            logger.info(" --- Table ${table.tableName()} already created ---")
        }
    }
}