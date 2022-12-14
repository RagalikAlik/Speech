package likco.myspeech.ui.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import likco.myspeech.App
import likco.myspeech.ui.Fragments

@Composable
fun SettingsScreen(state: MutableState<Fragments>)= Column(
    modifier = Modifier
        .fillMaxWidth()
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
                    .background(Color(1, 1, 1))
            )
        }

        Text(text = "Настройки")


    }

    Button(onClick = {
        App.isDarkTheme.value = true
    }) {
        Text(text = "Темная тема")

    }
}