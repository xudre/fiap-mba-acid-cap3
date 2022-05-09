package br.com.fiap.acid.cap3.repository

import br.com.fiap.acid.cap3.model.LocationData
import br.com.fiap.acid.cap3.model.ProductData
import br.com.fiap.acid.cap3.model.UserData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.util.*

class StoreRepositoryImpl : StoreRepository {

    private val db by lazy { Firebase.firestore }

    override fun registerAccess(time: Calendar, location: LocationData) {
        // Salvando um dado não estruturado no Firebase Firestore:
        val now = Calendar.getInstance()
        val data = hashMapOf<String, Any>(
            "time" to time.timeInMillis,
            "lat" to location.lat,
            "lng" to location.lng,
            "created" to now.timeInMillis,
        )

        db.collection(COLLECTION_ACCESS)
            .add(data)
            .addOnCompleteListener {

            }
            .addOnFailureListener {

            }
    }

    override fun retrieveUsers(onComplete: (List<UserData>) -> Unit) {
        db.collection(COLLECTION_USER)
            .get()
            .addOnCompleteListener { task ->
                val list = mutableListOf<UserData>()

                task.result.documents.forEach { snapshot ->
                    snapshot.toObject<UserData>()?.let { user ->
                        list.add(user)
                    }
                }

                onComplete(list.toList())
            }
    }

    override fun saveUser(
        user: UserData,
        onComplete: (UserData?, Exception?) -> Unit
    ) {
        // Salvando um dado estruturado no Firebase Firestore:
        if (user.id != null) {
            db.collection(COLLECTION_USER)
                .document(user.id)
                .set(user)
                .addOnCompleteListener {
                    onComplete(user, null)
                }
                .addOnFailureListener {
                    onComplete(null, it)
                }
        } else {
            db.collection(COLLECTION_USER)
                .add(user)
                .addOnCompleteListener { task ->
                    task.result.get()
                        .addOnCompleteListener { taskSnapshot ->
                            onComplete(taskSnapshot.result.toObject<UserData>(), null)
                        }
                }
                .addOnFailureListener {
                    onComplete(null, it)
                }
        }
    }

    override fun retrieveProduct(onComplete: (List<ProductData>) -> Unit) {
        db.collection(COLLECTION_PRODUCT)
            .get()
            .addOnCompleteListener { task ->
                val list = mutableListOf<ProductData>()

                task.result.documents.forEach { snapshot ->
                    snapshot.toObject<ProductData>()?.let { product ->
                        list.add(product)
                    }
                }

                onComplete(list.toList())
            }
    }

    override fun saveProduct(
        product: ProductData,
        onComplete: (ProductData?, Exception?) -> Unit
    ) {
        // Salvando um dado estruturado no Firebase Firestore:
        if (product.id != null) {
            db.collection(COLLECTION_PRODUCT)
                .document(product.id)
                .set(product)
                .addOnCompleteListener {
                    onComplete(product, null)
                }
                .addOnFailureListener {
                    onComplete(null, it)
                }
        } else {
            db.collection(COLLECTION_PRODUCT)
                .add(product)
                .addOnCompleteListener { task ->
                    task.result.get()
                        .addOnCompleteListener { taskSnapshot ->
                            onComplete(taskSnapshot.result.toObject<ProductData>(), null)
                        }
                }
                .addOnFailureListener {
                    onComplete(null, it)
                }
        }
    }

    companion object {
        private const val COLLECTION_ACCESS = "access"
        private const val COLLECTION_USER = "user"
        private const val COLLECTION_PRODUCT = "product"
    }

}