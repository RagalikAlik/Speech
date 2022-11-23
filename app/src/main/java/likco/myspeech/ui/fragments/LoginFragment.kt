package likco.myspeech.ui.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import likco.myspeech.App
import likco.myspeech.ui.Fragments
import likco.myspeech.utils.catching

@Composable
fun LoginScreen(state: MutableState<Fragments>) = Column(
    modifier = Modifier
        .fillMaxWidth()
) {
    Text("Speech", fontSize = 28.sp)

    Column(
        verticalArrangement = Arrangement.spacedBy(
            15.dp,
            Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .padding(horizontal = 60.dp)
    ) {
        var login by remember {
            mutableStateOf("")
        }

        var password by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            label = { Text(text = "Login") },
            modifier = Modifier
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation('\u30FB'),
            modifier = Modifier
                .fillMaxWidth()
        )

        Button(
            onClick = {
                catching {

                    App.user = App.userController.login(login, password)
                    state.value = Fragments.MAIN

                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            Text(text = "Login")
        }

        TextButton(
            onClick = { state.value = Fragments.SIGNUP }
        ) {
            Text(text = "Signup")
        }
    }

}