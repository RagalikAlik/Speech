package likco.myspeech.ui.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import likco.myspeech.ui.Fragments

@Composable
fun SettingsScreen(state: MutableState<Fragments>)= Column(
    modifier = Modifier
        .fillMaxWidth()
) {
    Text(text = "Настройки")
}