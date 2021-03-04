package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request

import com.felipepossari.dynamodb.application.domain.User

data class UserCreateRequest(
        val email: String = "",
        val name: String = "",
        val phone: String = "",
        val password: String = ""
)

fun UserCreateRequest.toDomain(): User =
        User(email = this.email,
                name = this.name,
                phone = this.phone,
                password = this.password)