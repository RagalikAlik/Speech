package likco.myspeech.ui.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.fragment.app.Fragment
import likco.myspeech.App
import likco.myspeech.ui.Fragments
import java.lang.reflect.Modifier


@Composable
fun ProfileScreen(state: MutableState<Fragments>)= Column(
    modifier = androidx.compose.ui.Modifier
        .fillMaxWidth()
){
    Column(
        verticalArrangement=Arrangement.Top

    ) {
        Text(text =App.user?.login ?: "")
    }

}