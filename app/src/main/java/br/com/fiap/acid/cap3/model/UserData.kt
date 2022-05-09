package br.com.fiap.acid.cap3.model

import java.io.Serializable

data class UserData(
    val id: String? = null,
    val name: String = "",
    val email: String = "",
    val image: String? = null,
) : Serializable