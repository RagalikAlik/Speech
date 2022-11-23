package likco.myspeech

import likco.myspeech.controllers.UserController
import likco.myspeech.models.User
import likco.myspeech.utils.OnError

object App {
    var user: User? = null

    //потом будет инициализировано, если получать доступ до инициализации - пошлёт
    lateinit var userController: UserController

    lateinit var onError: OnError
}