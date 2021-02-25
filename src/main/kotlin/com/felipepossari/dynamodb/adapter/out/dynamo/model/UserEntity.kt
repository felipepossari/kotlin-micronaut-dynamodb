package com.felipepossari.dynamodb.adapter.out.dynamo.model

import com.felipepossari.dynamodb.application.domain.User
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey

@DynamoDbBean
data class UserEntity(
        @get:DynamoDbPartitionKey
        var email: String = "",

        @get:DynamoDbAttribute("name")
        var name: String = "",

        @get:DynamoDbAttribute("phone")
        var phone: String = "",

        @get:DynamoDbAttribute("password")
        var password: String = ""
){
        constructor(user: User): this(
                email = user.email,
                name = user.name,
                phone = user.phone,
                password= user.password)
}