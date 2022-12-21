package likco.myspeech.repository.models

import java.util.Calendar
import java.util.Date

data class MessageModel(
    val message: String = "",
    val type: String = "",
    var userFrom: String = "",
    var userTo: String = "",
    var TimeStamp: Date = Calendar.getInstance().time
    )