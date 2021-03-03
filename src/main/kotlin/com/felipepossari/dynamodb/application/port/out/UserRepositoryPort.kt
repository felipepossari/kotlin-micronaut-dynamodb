package com.felipepossari.dynamodb.application.port.out

import com.felipepossari.dynamodb.application.domain.User

interface UserRepositoryPort {

    fun save(user: User)

    fun findByEmail(email: String) : User?
}