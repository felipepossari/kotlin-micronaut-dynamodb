package com.felipepossari.dynamodb.adapter.out.dynamo.model

import com.felipepossari.dynamodb.application.domain.Motorcycle
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
class MotorcycleEntity() {

    @get:DynamoDbPartitionKey
    lateinit var pk: String

    @get:DynamoDbSortKey
    lateinit var sk: String

    @get:DynamoDbAttribute("id")
    lateinit var id: String

    @get:DynamoDbAttribute("brand")
    lateinit var brand: String

    @get:DynamoDbAttribute("model")
    lateinit var model: String

    @get:DynamoDbAttribute("manufactureYear")
    var manufactureYear: Int = 0

    @get:DynamoDbAttribute("modelYear")
    var modelYear: Int = 0

    @get:DynamoDbAttribute("color")
    lateinit var color: String

    constructor(compositeKey: MotorcycleCompositeKey, motorcycle: Motorcycle) : this() {
        pk = compositeKey.pk
        sk = compositeKey.sk
        id = motorcycle.id
        brand = motorcycle.brand
        model = motorcycle.model
        manufactureYear = motorcycle.manufactureYear
        modelYear = motorcycle.modelYear
        color = motorcycle.color
    }
}

fun MotorcycleEntity.toDomain() =
        Motorcycle(
                id = this.id,
                brand = this.brand,
                model = this.model,
                manufactureYear = this.manufactureYear,
                modelYear = this.modelYear,
                color = this.color
        )