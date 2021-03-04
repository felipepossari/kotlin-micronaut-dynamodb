package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request

import com.felipepossari.dynamodb.application.domain.User

data class UserUpdateRequest(
        val name: String = "",
        val phone: String = "",
        val password: String = ""
)

fun UserUpdateRequest.toDomain(): User =
        User(name = this.name,
                phone = this.phone,
                password = this.password)