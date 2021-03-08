package com.felipepossari.dynamodb.application.exception.model

enum class ErrorReason(val code: String, val message: String) {

    EMAIL_INVALID("001", "Email cannot be null or bigger than 255 characters"),
    NAME_INVALID("002", "Name cannot be null or bigger than 255 characters"),
    PHONE_INVALID("003", "Phone cannot be null or bigger than 25 characters"),
    PASSWORD_INVALID("004", "Password cannot be null"),

    ID_INVALID("005", "Id cannot be null or invalid"),
    BRAND_INVALID("006", "Brand cannot be null or bigger than 255 characters"),
    MODEL_INVALID("007", "Model cannot be null or bigger than 255 characters"),
    MANUFACTURE_YEAR_INVALID("008", "Manufacture year invalid"),
    MODEL_YEAR_INVALID("009", "Model year invalid"),
    COLOR_INVALID("010", "Color cannot be null or bigger than 255 characters"),

    RESOURCE_ALREADY_EXISTS("011", "Resource already exists"),
    RESOURCE_NOT_FOUND("012", "Resource not found")
}