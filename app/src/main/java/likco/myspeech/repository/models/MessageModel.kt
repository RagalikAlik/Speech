package likco.myspeech.repository.models

data class MessageModel(
    val message: String = "",
    val type: String = "",
    var userFrom: String = "",
    var userTo: String = "",
    var TimeStamp: String = ""
    )