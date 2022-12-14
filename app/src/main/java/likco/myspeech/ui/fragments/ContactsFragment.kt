package likco.myspeech.ui.fragments

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import likco.myspeech.App
import likco.myspeech.MainActivity
import likco.myspeech.repository.models.Contact
import likco.myspeech.ui.Fragments
import java.lang.IllegalArgumentException

@Composable
fun ContactsScreen(state: MutableState<Fragments>)= Column(
    modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        IconButton(onClick = {
            state.value = Fragments.MAIN
        }) {
            Icon(
                Icons.Default.ArrowBack,
                null,
                modifier = Modifier
                    .background(Color(1, 1,1))
            )
        }

        Text(text = "Контакты")
    }

    var searchUser by remember {
        mutableStateOf("")
    }

    if(showDialog.value) {
        AlertNoSuchUser()
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = searchUser,
            onValueChange = {searchUser = it},
            label = { Text(text = "Поиск пользователя") },
            modifier=Modifier.width(330.dp)
        )

        IconButton(
            onClick = {
                try{
                    App.searchUserByLogin(login = searchUser)
                    App.addContact(App.user?.login ?: "", searchUser)
                }
                catch (e: IllegalArgumentException){
                    showDialog.value = true
                }

                searchUser=""
                      },
            modifier= Modifier
                .height(65.dp)
                .width(75.dp)
        ) {
            Icon(Icons.Default.Add,
                null,
                modifier = Modifier
                    .height(65.dp)
                    .width(75.dp)
            )
        }
    }

    val contacts= App.getAllContacts(App.user?.login ?: "")

    LazyColumn(
        modifier = Modifier
        .weight(1f)
    ) {
            items(contacts){
            Contact(state, login = it)
        }
    }
}

private val showDialog = mutableStateOf(false)
@Composable
fun AlertNoSuchUser(){
    val context = LocalContext.current
    Toast.makeText(context, "Пользователь не найден", Toast.LENGTH_SHORT).show()
    showDialog.value=false
}