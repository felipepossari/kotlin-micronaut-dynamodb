package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.response

import com.felipepossari.dynamodb.application.domain.User

data class UserResponse(
        val email: String = "",
        val name: String = "",
        val phone: String = "",
        val password: String = ""
) {
    constructor(user: User) : this(
            email = user.email,
            name = user.name,
            phone = user.phone,
            password = user.password)
}