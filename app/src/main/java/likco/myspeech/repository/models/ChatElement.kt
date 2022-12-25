package likco.myspeech.repository.models

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.unit.dp
import likco.myspeech.App
import likco.myspeech.ui.Fragments

@Composable
fun CreateChatElement(state: MutableState<Fragments>, login:String)= Row(
    modifier = Modifier
        .clickable {
            App.userToWrite = login
            state.value = Fragments.SINGLECHATFRAGMENT
        }
        .height(50.dp)
        .fillMaxWidth()
) {
    Text(text = login)
}