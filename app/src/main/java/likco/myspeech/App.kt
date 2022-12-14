package likco.myspeech

import androidx.compose.runtime.MutableState
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import likco.myspeech.controllers.UserController
import likco.myspeech.repository.UserRepository
import likco.myspeech.repository.models.User
import likco.myspeech.utils.OnError

object App {
    var user: User? = null

    lateinit var AUTH: FirebaseAuth
    lateinit var REF_DATABASE_ROOT: DatabaseReference
    lateinit var userController: UserController
    lateinit var onError: OnError
    lateinit var isDarkTheme: MutableState<Boolean>

    fun initFirebase() {
        AUTH = FirebaseAuth.getInstance()
        REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference

    }

    fun searchUserByLogin(login: String) {
        val db = Firebase.firestore
        val repository = UserRepository(db)

        val user = repository.getUserByLogin(login) ?: throw IllegalArgumentException("no such user")
    }

    fun addContact(user: String, contact: String): Unit = runBlocking {
        val db = Firebase.firestore
        val usersCollection: CollectionReference = db.collection("users")

        usersCollection.document(user).collection("contacts").document(contact)
            .set(emptyMap<String, String>()).await()
    }

    fun getAllContacts(user: String): List<String> {
        val contacts: MutableList<String> = mutableListOf()

        val db = Firebase.firestore
        val contactColl: Task<QuerySnapshot> =
            db.collection("users").document(user).collection("contacts").get()
                .addOnSuccessListener { documents ->
                    for (document in documents)
                        contacts.add(document.toString())
                }

        return contacts
    }
}