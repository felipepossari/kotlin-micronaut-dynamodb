package com.felipepossari.dynamodb.adapter.out.dynamo

import com.felipepossari.dynamodb.adapter.out.dynamo.model.UserEntity
import com.felipepossari.dynamodb.adapter.out.dynamo.model.toDomain
import com.felipepossari.dynamodb.application.domain.User
import com.felipepossari.dynamodb.application.port.out.UserRepositoryPort
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.Key.builder
import javax.inject.Singleton

@Singleton
class UserRepository(
        private val userTable: DynamoDbTable<UserEntity>
) : UserRepositoryPort {

    override fun save(user: User) {
        userTable.putItem(UserEntity(
                user.email,
                user.name,
                user.phone,
                user.password
        ))
    }

    override fun findByEmail(email: String): User? =
            userTable.getItem(createPartitionKey(email))?.toDomain()

    private fun createPartitionKey(email: String) =
            builder().partitionValue(email).build()
}