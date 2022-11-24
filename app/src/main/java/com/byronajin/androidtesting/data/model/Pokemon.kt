package com.byronajin.androidtesting.data.model

import java.io.Serializable

class Pokemon(
    val name: String,
    val url: String,
    var number: Int
) : Serializable