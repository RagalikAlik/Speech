package likco.myspeech

import androidx.compose.runtime.MutableState
import likco.myspeech.controllers.UserController
import likco.myspeech.repository.models.User
import likco.myspeech.utils.OnError

object App {
    var user: User? = null

    //потом будет инициализировано, если получать доступ до инициализации - пошлёт
    lateinit var userController: UserController
    lateinit var onError: OnError
    lateinit var isDarkTheme: MutableState<Boolean>
}