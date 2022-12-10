package likco.myspeech.ui.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import likco.myspeech.App
import likco.myspeech.R
import likco.myspeech.repository.models.Contact
import likco.myspeech.repository.models.CreateMyMessage
import likco.myspeech.ui.Fragments

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

    Column(
        modifier = Modifier
        .fillMaxSize()
    ) {
        Contact(imageId = R.drawable.empty_profile_picture, login = App.user?.login ?: "")
    }


}