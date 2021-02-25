package com.felipepossari.dynamodb.infrastructure.configuration

import com.felipepossari.dynamodb.adapter.out.dynamo.model.UserEntity
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI

@Factory
class DynamoDbConfig {

    @Bean
    fun dynamoDbClient(): DynamoDbClient {
        return DynamoDbClient.builder()
                .region(Region.SA_EAST_1)
                .endpointOverride(URI.create("http://localhost:8000"))
                .build()
    }

    @Bean
    fun dynamoDbClientEnhanced(): DynamoDbEnhancedClient {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient())
                .build()
    }

    @Bean
    fun userTable(): DynamoDbTable<UserEntity> {
        val userTable = dynamoDbClientEnhanced()
                .table("user", TableSchema.fromBean(UserEntity::class.java))

        userTable.createTable()
        return userTable
    }
}