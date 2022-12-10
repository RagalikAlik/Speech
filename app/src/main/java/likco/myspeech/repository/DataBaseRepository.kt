package likco.myspeech.repository

import android.content.Context
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ServerValue
import com.google.firebase.firestore.FirebaseFirestore

public class DataBaseRepository (db: FirebaseFirestore) {
    val NODE_MESSAGES= "messages"
    var CURRENT_ID="id"
    val ID="login"
    val CHILD_TEXT="text"
    val CHILD_TYPE="type"
    val CHILD_FROM="from"
    val CHILD_TIMESTAMP="timeStamp"

    lateinit var REF_DATABASE_ROOT: DatabaseReference

    public fun sendMessage(context: Context, message: String, id: String, childType: String, function: () -> Unit) {
        val refDialogUser = "$NODE_MESSAGES/$CURRENT_ID/$id"
        val refDialogReseivingUser = "$NODE_MESSAGES/$id/$CURRENT_ID"
        val messageKey= REF_DATABASE_ROOT.child(refDialogUser).push().key

        val mapMessage = hashMapOf<String, Any>()
        mapMessage[CHILD_FROM] = CURRENT_ID
        mapMessage[CHILD_TYPE] = childType
        mapMessage[CHILD_TEXT] = message
        mapMessage[CHILD_TIMESTAMP] = ServerValue.TIMESTAMP

        val mapDialog= hashMapOf<String, Any>()
        mapDialog["$refDialogUser/$messageKey"] = mapMessage
        mapDialog["$refDialogReseivingUser/$messageKey"] = mapMessage

        REF_DATABASE_ROOT
            .updateChildren(mapDialog)
            .addOnSuccessListener { function() }
            .addOnFailureListener { Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()}

    }

}