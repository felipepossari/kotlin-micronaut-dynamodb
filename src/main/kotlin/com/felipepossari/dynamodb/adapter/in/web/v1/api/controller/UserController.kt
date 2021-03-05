package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.controller

import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.UserApi
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.UserCreateRequest
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.UserUpdateRequest
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request.toDomain
import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.response.UserResponse
import com.felipepossari.dynamodb.application.port.`in`.CreateUserUseCase
import com.felipepossari.dynamodb.application.port.`in`.DeleteUserUseCase
import com.felipepossari.dynamodb.application.port.`in`.FindUserByEmailUseCase
import com.felipepossari.dynamodb.application.port.`in`.UpdateUserUseCase
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller("/users")
class UserController(
        private val createUserUseCase: CreateUserUseCase,
        private val findUserByEmailUseCase: FindUserByEmailUseCase,
        private val updateUserUseCase: UpdateUserUseCase,
        private val deleteUserUseCase: DeleteUserUseCase
) : UserApi {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    override fun post(userRequest: UserCreateRequest): HttpResponse<UserResponse> {
        logger.info("Creating user")
        val user = createUserUseCase.execute(userRequest.toDomain())
        return HttpResponse.created(UserResponse(user))
    }

    override fun put(email: String, userRequest: UserUpdateRequest): HttpResponse<UserResponse> {
        logger.info("Updating user")
        val updatedUser = updateUserUseCase.execute(email, userRequest.toDomain())
        return HttpResponse.ok(UserResponse(updatedUser))
    }

    override fun getByEmail(email: String): HttpResponse<UserResponse> {
        logger.info("Getting user by email")
        val user = findUserByEmailUseCase.execute(email)
        return HttpResponse.ok(UserResponse(user))
    }

    override fun delete(email: String): HttpResponse<*> {
        logger.info("Deleting user")
        deleteUserUseCase.execute(email)
        return HttpResponse.noContent<Unit>()
    }

}