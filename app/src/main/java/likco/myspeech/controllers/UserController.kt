package likco.myspeech.controllers

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import likco.myspeech.repository.models.User
import likco.myspeech.repository.UserRepository
import likco.myspeech.ui.fragments.LoginScreen
import org.mindrot.jbcrypt.BCrypt

class UserController(private val repository: UserRepository) {
    fun login(login: String, password: String): User {
        val user = repository.getUserByLogin(login) ?: throw IllegalArgumentException("no such user")
        if (!BCrypt.checkpw(password, user.password)) {
            throw IllegalArgumentException("passwords mismatch")
        }
        return user
    }

    fun signUp(login: String, email: String, password: String, passwordConfirm: String) {
        if (password != passwordConfirm) throw IllegalArgumentException("passwords mismatch")

        val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
        val user = User(login, hashedPassword, email)

        this.repository.signUpUser(user)
    }

}