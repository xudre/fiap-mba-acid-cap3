package br.com.fiap.acid.cap3.viewmodel

import androidx.lifecycle.ViewModel
import br.com.fiap.acid.cap3.model.LocationData
import br.com.fiap.acid.cap3.model.ProductData
import br.com.fiap.acid.cap3.model.UserData
import br.com.fiap.acid.cap3.repository.StoreRepository
import br.com.fiap.acid.cap3.repository.StoreRepositoryImpl
import java.util.*

class StoreViewModel : ViewModel() {

    private val repository: StoreRepository = StoreRepositoryImpl()

    fun registerAccess() {
        repository.registerAccess(Calendar.getInstance(), LocationData(0.0, 0.0))
    }

    fun saveUser(user: UserData, onComplete: (UserData?, Exception?) -> Unit) {
        repository.saveUser(user) { savedUser, exception ->
            onComplete(savedUser, exception)
        }
    }

    fun retrieveUsers(onComplete: (List<UserData>) -> Unit) {
        repository.retrieveUsers { onComplete(it) }
    }

    fun updateUser(user: UserData) {

    }

    fun removeUser(user: UserData) {

    }

    fun createProduct(product: ProductData) {

    }

    fun retrieveProducts(onComplete: (List<ProductData>) -> Unit) {
        repository.retrieveProduct { onComplete(it) }
    }

    fun updateProduct(product: ProductData) {

    }

    fun removeProduct(product: ProductData) {

    }

}
