package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.response

data class MotorcycleResponse(
        val id: String,
        val brand: String,
        val model: String,
        val manufactureYear: Int,
        val modelYear: Int,
        val color: String
)
