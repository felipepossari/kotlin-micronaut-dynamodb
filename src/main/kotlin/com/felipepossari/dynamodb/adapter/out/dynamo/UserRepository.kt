package com.felipepossari.dynamodb.adapter.out.dynamo

import com.felipepossari.dynamodb.adapter.out.dynamo.model.UserCompositeKey
import com.felipepossari.dynamodb.adapter.out.dynamo.model.UserEntity
import com.felipepossari.dynamodb.adapter.out.dynamo.model.toDomain
import com.felipepossari.dynamodb.adapter.out.dynamo.model.toKey
import com.felipepossari.dynamodb.application.domain.User
import com.felipepossari.dynamodb.application.port.out.UserRepositoryPort
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import javax.inject.Singleton

@Singleton
class UserRepository : UserRepositoryPort {

    private val userTable: DynamoDbTable<UserEntity>

    constructor(dynamoDbClientEnhancedClient: DynamoDbEnhancedClient) {
        userTable = dynamoDbClientEnhancedClient
                .table(TABLE_NAME, TableSchema.fromBean(UserEntity::class.java))
    }

    override fun create(user: User) {
        val key = UserCompositeKey(user.email)
        userTable.putItem(UserEntity(key, user))
    }

    override fun findByEmail(email: String): User? {
        val key = UserCompositeKey(email).toKey()
        return userTable.getItem(key)?.toDomain()
    }

    override fun update(user: User) {
        val key = UserCompositeKey(user.email)
        userTable.updateItem(UserEntity(key, user))
    }

    override fun delete(email: String) {
        val key = UserCompositeKey(email).toKey()
        userTable.deleteItem(key)
    }
}