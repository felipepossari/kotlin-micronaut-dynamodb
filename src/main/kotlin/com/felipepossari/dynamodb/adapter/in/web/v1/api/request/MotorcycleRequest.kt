package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request

data class MotorcycleRequest(
        val brand: String,
        val model: String,
        val manufactureYear: Int,
        val modelYear: Int,
        val color: String
)
