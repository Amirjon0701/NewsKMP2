package com.example.newskmp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Source (
    @SerialName("id")
    val id: String? = null,
    @SerialName("name")
    val name: String
)