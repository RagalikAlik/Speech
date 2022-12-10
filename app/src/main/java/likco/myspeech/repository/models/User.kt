package likco.myspeech.repository.models

data class User(
    val type: String="",

    val login: String = "",
    val password: String = "",
    var bio: String="",
    var email: String = "",

    var text: String= "",
    var from: String="",
    var timeStamp: String="",

    )