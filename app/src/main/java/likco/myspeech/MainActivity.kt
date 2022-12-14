package likco.myspeech

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import likco.myspeech.App.initFirebase
import likco.myspeech.controllers.UserController
import likco.myspeech.repository.UserRepository
import likco.myspeech.ui.Fragments
import likco.myspeech.ui.fragments.ContactsScreen
import likco.myspeech.ui.fragments.LoginScreen
import likco.myspeech.ui.fragments.MainScreen
import likco.myspeech.ui.fragments.SignupScreen
import likco.myspeech.ui.fragments.ProfileScreen
import likco.myspeech.ui.fragments.SettingsScreen
import likco.myspeech.ui.fragments.SingleChatScreen
import likco.myspeech.ui.theme.MySpeechTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Firebase.firestore
        val repo = UserRepository(db)
        App.userController = UserController(repo)

        initFirebase()

        setContent {
            val scope = rememberCoroutineScope()
            val focusManager = LocalFocusManager.current
            val scaffoldState = rememberScaffoldState()


            App.onError = { error: Throwable ->
                scope.launch {
                    focusManager.clearFocus()
                    delay(50L)
                    scaffoldState.snackbarHostState.showSnackbar(error.message ?: "Unknown error occurred")
                }
            }
            MySpeechTheme {
                Scaffold(

                        modifier = Modifier
                            .background(MaterialTheme.colors.background)
                            .fillMaxSize()
                            .padding(),
                    content = {

                        val currentState = remember {
                            mutableStateOf(Fragments.LOGIN)
                        }

                        when (currentState.value) {
                            Fragments.LOGIN -> LoginScreen(currentState)
                            Fragments.SIGNUP -> SignupScreen(currentState)
                            Fragments.MAIN -> MainScreen(currentState)
                            Fragments.PROFILE-> ProfileScreen(currentState)
                            Fragments.SETTINGS-> SettingsScreen(currentState)
                            Fragments.SINGLECHATFRAGMENT-> SingleChatScreen(currentState, App.userToWrite)
                            Fragments.CONTACTS-> ContactsScreen(currentState)
                        }
                    }
                )
            }
        }
    }
}
