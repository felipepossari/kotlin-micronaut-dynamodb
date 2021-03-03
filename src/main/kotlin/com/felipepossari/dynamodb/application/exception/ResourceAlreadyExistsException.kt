package com.felipepossari.dynamodb.application.exception

import com.felipepossari.dynamodb.application.exception.model.ErrorReason

class ResourceAlreadyExistsException(private val errorReason: ErrorReason): BaseException(listOf(errorReason)) {
}