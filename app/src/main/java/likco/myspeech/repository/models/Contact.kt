package likco.myspeech.repository.models

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import likco.myspeech.App
import likco.myspeech.R
import likco.myspeech.ui.Fragments

@Composable
fun Contact(state: MutableState<Fragments>, login:String)= Row(
    modifier= Modifier
        .fillMaxWidth()
        .height(50.dp)
        .padding(bottom = 10.dp),


    ) {
    Image(
        bitmap = ImageBitmap.imageResource(R.drawable.empty_profile_picture) ,
        contentDescription = "photo",
    )

    Text(
        text = login,
        fontSize = 20.sp
    )

    Row(modifier = Modifier.weight(1f)){}

    if(showDialog.value) {
        menuButton(login)
    }


    IconButton(
        onClick = {
            App.userToWrite = login
            state.value= Fragments.SINGLECHATFRAGMENT
        },
    ) {
        Icon(
            Icons.Default.Menu,
            null
        )
    }
}
@Composable
fun Menu(user: String){
    var arg = false
    DropdownMenu(
        expanded = arg,
        onDismissRequest = { arg = true }
    ) {
        Text("Скопировать", fontSize=18.sp, modifier = Modifier
            .padding(10.dp)
            .clickable(onClick = {}))
        Text("Вставить", fontSize=18.sp, modifier = Modifier
            .padding(10.dp)
            .clickable(onClick = {}))
        Divider()
        Text("Настройки", fontSize=18.sp, modifier = Modifier
            .padding(10.dp)
            .clickable(onClick = {}))
    }
}

private var showDialog = mutableStateOf(false)
@Composable
fun menuButton( user: String){
    Menu(user)
    showDialog.value=false
}