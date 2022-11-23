package likco.myspeech.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import likco.myspeech.repository.models.User


class UserRepository(db: FirebaseFirestore) {
    private val usersCollection: CollectionReference = db.collection("users")

    fun getUserByLogin(login: String): User? = runBlocking{
        val userDoc = usersCollection.document(login).get().await() as DocumentSnapshot
        userDoc.toObject<User>()
    }

    fun signUpUser(user: User): Unit = runBlocking {
        usersCollection.document(user.login).set(user).await()
    }
}