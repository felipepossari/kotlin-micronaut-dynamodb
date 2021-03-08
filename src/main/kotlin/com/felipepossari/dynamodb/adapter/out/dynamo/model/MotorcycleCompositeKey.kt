package com.felipepossari.dynamodb.adapter.out.dynamo.model

import com.felipepossari.dynamodb.adapter.out.dynamo.MOTORCYCLE_HASH_KEY
import com.felipepossari.dynamodb.adapter.out.dynamo.MOTORCYCLE_SORT_KEY
import software.amazon.awssdk.enhanced.dynamodb.Key

class MotorcycleCompositeKey {

    var pk: String = ""
    var sk: String = ""

    constructor(email: String) {
        pk = "$MOTORCYCLE_HASH_KEY$email"
    }

    constructor(email: String, motorcycleId: String) {
        pk = "$MOTORCYCLE_HASH_KEY$email"
        sk = "$MOTORCYCLE_SORT_KEY$motorcycleId"
    }
}

fun MotorcycleCompositeKey.toKey(): Key =
        Key.builder()
                .partitionValue(pk)
                .sortValue(sk)
                .build()

fun MotorcycleCompositeKey.toGetAllMotorcycleKey(): Key =
        Key.builder()
                .partitionValue(pk)
                .sortValue(MOTORCYCLE_SORT_KEY)
                .build()