package com.cmaina.fotos.shared.data.network.models.photostats

data class Historical(
    val change: Int,
    val quantity: Int,
    val resolution: String,
    val values: List<Value>
)