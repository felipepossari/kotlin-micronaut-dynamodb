package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.controller.exceptionhandler

import com.felipepossari.dynamodb.adapter.`in`.web.v1.api.controller.exceptionhandler.model.Error
import com.felipepossari.dynamodb.application.exception.ResourceNotFoundException
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Produces
@Singleton
class ResourceNotFoundExceptionHandler : ExceptionHandler<ResourceNotFoundException, HttpResponse<*>> {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    override fun handle(request: HttpRequest<*>, exception: ResourceNotFoundException): HttpResponse<*> {
        logger.warn("Resource not found exception handler executed")
        return HttpResponse.notFound(exception.errors.map { Error(code = it.code, message = it.message) })
    }
}