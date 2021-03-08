package com.felipepossari.dynamodb.adapter.`in`.web.v1.api.request

import com.felipepossari.dynamodb.application.domain.Motorcycle

data class MotorcycleRequest(
        val brand: String,
        val model: String,
        val manufactureYear: Int,
        val modelYear: Int,
        val color: String
)

fun MotorcycleRequest.toDomain(): Motorcycle =
        Motorcycle(
                brand = this.brand,
                model = this.model,
                manufactureYear = this.manufactureYear,
                modelYear = this.modelYear,
                color = this.color
        )

fun MotorcycleRequest.toDomain(id: String): Motorcycle =
        Motorcycle(
                id = id,
                brand = this.brand,
                model = this.model,
                manufactureYear = this.manufactureYear,
                modelYear = this.modelYear,
                color = this.color
        )

