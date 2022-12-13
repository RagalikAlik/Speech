package likco.myspeech

import androidx.compose.runtime.MutableState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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

    fun initFirebase(){
        AUTH= FirebaseAuth.getInstance()
        REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference

    }

    fun searchUserByLogin(login: String){
        val db = Firebase.firestore
        val repository= UserRepository(db)

        val user = repository.getUserByLogin(login) ?: throw IllegalArgumentException("no such user")
    }

    fun addContact(user: String, contact: String){
        val db = Firebase.firestore
        val usersCollection: CollectionReference = db.collection("users")
        usersCollection.document(user).collection("Contacts").add(contact)
    }
}