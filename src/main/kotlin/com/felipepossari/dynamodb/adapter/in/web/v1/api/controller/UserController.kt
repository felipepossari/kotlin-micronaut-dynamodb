package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.controller

import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.UserApi
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.UserRequest
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.toDomain
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.response.UserResponse
import com.felipepossari.dynamodb.application.port.`in`.CreateUserUseCase
import com.felipepossari.dynamodb.application.port.`in`.FindUserByEmailUseCase
import com.felipepossari.dynamodb.application.port.`in`.UpdateUserUseCase
import io.micronaut.http.annotation.Controller
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller("/users")
class UserController(
        private val createUserUseCase: CreateUserUseCase,
        private val findUserByEmailUseCase: FindUserByEmailUseCase,
        private val updateUserUseCase: UpdateUserUseCase
) : UserApi {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    override fun post(userRequest: UserRequest): UserResponse {
        logger.info("Creating user")
        val user = createUserUseCase.execute(userRequest.toDomain())
        return UserResponse(user)
    }

    override fun put(email: String, userRequest: UserRequest): UserResponse {
        logger.info("Updating user")
        return UserResponse(updateUserUseCase.execute(email, userRequest.toDomain()))
    }

    override fun getByEmail(email: String): UserResponse {
        logger.info("Getting user by email")
        return UserResponse(findUserByEmailUseCase.execute(email))
    }

    override fun delete(email: String): UserResponse {
        logger.info("Deleting user")
        TODO("Not yet implemented")
    }

}