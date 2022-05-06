package br.com.fiap.acid.cap3.viewmodel

import androidx.lifecycle.ViewModel
import br.com.fiap.acid.cap3.model.ProductData
import br.com.fiap.acid.cap3.model.UserData
import br.com.fiap.acid.cap3.repository.StoreRepository
import br.com.fiap.acid.cap3.repository.StoreRepositoryImpl

class StoreViewModel : ViewModel() {

    val repository: StoreRepository = StoreRepositoryImpl()

    fun createUser(user: UserData) {

    }

    fun retrieveUsers() {

    }

    fun updateUser(user: UserData) {

    }

    fun removeUser(user: UserData) {

    }

    fun createProduct(product: ProductData) {

    }

    fun retrieveProducts() {

    }

    fun updateProduct(product: ProductData) {

    }

    fun removeProduct(product: ProductData) {

    }

}
