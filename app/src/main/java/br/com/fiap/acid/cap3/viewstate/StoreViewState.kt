package br.com.fiap.acid.cap3.viewstate

import br.com.fiap.acid.cap3.model.ProductData
import br.com.fiap.acid.cap3.model.UserData

sealed class StoreViewState(
    val state: String
) {

    object Loading :
        StoreViewState(Loading::javaClass.name)

    data class UserCreated(val user: UserData) :
        StoreViewState(UserCreated::javaClass.name)

    data class ProductCreated(val product: ProductData) :
        StoreViewState(ProductCreated::javaClass.name)

}