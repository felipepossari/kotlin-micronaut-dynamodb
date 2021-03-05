package com.felipepossari.dynamodb.adapter.out.dynamo.model

import com.felipepossari.dynamodb.application.domain.User
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
class UserEntity() {

    @get:DynamoDbPartitionKey
    lateinit var pk: String

    @get:DynamoDbSortKey
    lateinit var  sk: String

    @get:DynamoDbAttribute("email")
    lateinit var email: String

    @get:DynamoDbAttribute("name")
    lateinit var name: String

    @get:DynamoDbAttribute("phone")
    lateinit var phone: String

    @get:DynamoDbAttribute("password")
    lateinit var password: String

    companion object {
        const val TABLE_NAME: String = "users"
    }

    constructor(compositeKey: UserCompositeKey, user: User) : this() {
        pk = compositeKey.pk
        sk = compositeKey.sk
        email = user.email
        name = user.name
        phone = user.phone
        password = user.password
    }
}

fun UserEntity.toDomain() =
        User(
                email = this.email,
                name = this.name,
                phone = this.phone,
                password = this.password)

