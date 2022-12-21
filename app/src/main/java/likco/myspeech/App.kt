package likco.myspeech

import androidx.compose.runtime.MutableState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import likco.myspeech.controllers.UserController
import likco.myspeech.repository.UserRepository
import likco.myspeech.repository.models.User
import likco.myspeech.utils.OnError
import java.util.Calendar

object App {
    var user: User? = null

    var userToWrite: String = ""

    private lateinit var AUTH: FirebaseAuth
    private lateinit var REF_DATABASE_ROOT: DatabaseReference
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

    fun getAllContacts(user: String): List<String> = runBlocking {
        val db = Firebase.firestore
        val contactsSnapshot = db.collection("users").document(user).collection("contacts").get().await()

        contactsSnapshot.documents.map { it.id }
    }

    fun addMessageToDB(message: String, type: String, userFrom: String, userTo: String) = runBlocking{
        val map = HashMap<String, Any>()

        map["message"] = message
        map["type"] = type
        map["userFrom"] = userFrom
        map["userTo"] = userTo
        map["TimeStamp"] = Calendar.getInstance().time;

        val db = Firebase.firestore
        db.collection("users").document(userFrom).collection("contacts")
            .document(userTo).collection("messages").document().set(map).await()
    }

    fun addMessageToFriendDB(message: String, type: String, userFrom: String, userTo: String) = runBlocking{
        val map = HashMap<String, Any>()

        map["message"] = message
        map["type"] = type
        map["userFrom"] = userFrom
        map["userTo"] = userTo
        map["TimeStamp"] = Calendar.getInstance().time

        val db = Firebase.firestore
        db.collection("users").document(userTo).collection("contacts")
            .document(userFrom).collection("messages").document().set(map).await()

    }

    fun readSenderMessagesFromDB(userFrom: String, userTo: String): List<MutableMap<String, Any>?> = runBlocking{

        val db = Firebase.firestore
        val messagesSnapshot = db.collection("users").document(userFrom).collection("contacts")
            .document(userTo).collection("messages").get().await()

        messagesSnapshot.documents.map { it.data }
    }

}