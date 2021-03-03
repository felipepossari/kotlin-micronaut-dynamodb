package com.felipepossari.dynamodb.application.exception

import com.felipepossari.dynamodb.application.exception.model.ErrorReason

class InvalidUpdateFieldException(private val errorReason: ErrorReason): BaseException(listOf(errorReason)) {
}