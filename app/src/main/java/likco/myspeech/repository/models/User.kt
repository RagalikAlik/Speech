package likco.myspeech.repository.models

data class User(
    val login: String = "",
    val password: String = "",
    var email: String = "",
    var studyPlace: String = ""
    )