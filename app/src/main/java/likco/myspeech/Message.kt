package likco.myspeech

import com.google.firebase.firestore.FieldValue

class Message {
    var senderID: String = ""
    var receiverID: String = ""
    var type: String=""
    var text = ""
    var timeStamp : FieldValue = FieldValue.arrayRemove()

    init {
        this.senderID
        this.receiverID
        this.type
        this.text
        this.timeStamp
    }


    fun toMap(): HashMap<String, Any>{
        val map = HashMap<String, Any>()

        map["senderID"]=this.senderID
        map["receiverID"]=this.receiverID
        map["type"] = this.type
        map["text"] = this.text
        map["timeStamp"] = this.timeStamp

        return map
    }

    fun fromMap(map: HashMap<String, Any>):Message{
        val _message = Message()
        _message.senderID = map["senderID"].toString()
        _message.receiverID = map["receiverID"].toString()
        _message.type = map["type"].toString()
        _message.text = map["text"].toString()
        _message.timeStamp = map["timeStamp"] as FieldValue

        return _message
    }
}