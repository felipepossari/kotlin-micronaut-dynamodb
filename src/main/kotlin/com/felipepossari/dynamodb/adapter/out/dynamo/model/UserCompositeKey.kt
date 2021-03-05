package com.felipepossari.dynamodb.adapter.out.dynamo.model

import com.felipepossari.dynamodb.adapter.out.dynamo.USER_HASH_KEY
import com.felipepossari.dynamodb.adapter.out.dynamo.USER_SORT_KEY
import software.amazon.awssdk.enhanced.dynamodb.Key

class UserCompositeKey {

    var pk: String
    var sk: String

    constructor(email: String) {
        pk = "$USER_HASH_KEY$email"
        sk = "$USER_SORT_KEY$email"
    }
}

fun UserCompositeKey.toKey(): Key = Key.builder()
        .partitionValue(pk)
        .sortValue(sk)
        .build()