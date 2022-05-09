package br.com.fiap.acid.cap3.repository

import br.com.fiap.acid.cap3.model.LocationData
import br.com.fiap.acid.cap3.model.ProductData
import br.com.fiap.acid.cap3.model.UserData
import java.util.*

interface StoreRepository {

    fun registerAccess(time: Calendar, location: LocationData)

    fun retrieveUsers(onComplete: (List<UserData>) -> Unit)

    fun saveUser(user: UserData, onComplete: (UserData?, Exception?) -> Unit)

    fun retrieveProduct(onComplete: (List<ProductData>) -> Unit)

    fun saveProduct(product: ProductData, onComplete: (ProductData?, Exception?) -> Unit)

}