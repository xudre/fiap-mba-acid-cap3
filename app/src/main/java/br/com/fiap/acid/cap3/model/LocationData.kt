package br.com.fiap.acid.cap3.model

import java.io.Serializable

data class LocationData(
    val lat: Double,
    val lng: Double,
) : Serializable