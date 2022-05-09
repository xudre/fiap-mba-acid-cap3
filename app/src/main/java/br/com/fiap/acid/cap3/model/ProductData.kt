package br.com.fiap.acid.cap3.model

import java.io.Serializable

data class ProductData(
    val id: String? = null,
    val name: String = "",
    val price: Double = 0.0,
    val image: String? = null,
) : Serializable
