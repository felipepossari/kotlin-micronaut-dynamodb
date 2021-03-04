package com.felipepossari.dynamodb.application.port.out

import com.felipepossari.dynamodb.application.domain.User

interface UserRepositoryPort {

    fun create(user: User)

    fun findByEmail(email: String) : User?

    fun update(user: User)
}