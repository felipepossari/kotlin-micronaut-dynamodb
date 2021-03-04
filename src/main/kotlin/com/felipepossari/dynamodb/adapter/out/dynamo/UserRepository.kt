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

    override fun create(user: User) {
        val entitiy = UserEntity(user)
        userTable.putItem(entitiy)
    }

    override fun findByEmail(email: String): User? =
            userTable.getItem(createPartitionKey(email))?.toDomain()

    override fun update(user: User) {
        userTable.updateItem(UserEntity(user))
    }

    private fun createPartitionKey(email: String) =
            builder()
                    .partitionValue("USER#$email")
                    .sortValue("PROFILE#$email")
                    .build()
}