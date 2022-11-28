package likco.myspeech.ui.fragments

import android.annotation.SuppressLint
import android.widget.Toolbar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import likco.myspeech.App
import likco.myspeech.R
import likco.myspeech.ui.Fragments

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SingleChatScreen(state: MutableState<Fragments>)= Column(
    modifier = Modifier
        .fillMaxWidth(),

) {
    var message by remember {
        mutableStateOf("")
    }

    TopAppBar(

    ) {

        IconButton(onClick = {  }) {
            Icon(Icons.Default.ArrowBack,
                null,
                modifier = Modifier
                    .background(Color(1, 1,1))

            )
        }

        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.empty_profile_picture),
            null,
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
        )

        Text(text = App.user?.login ?: "",fontSize = 20.sp)
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        OutlinedTextField(
            value = message,
            onValueChange = {message = it},
            label = { Text(text = "Message ") },
            modifier=Modifier.padding(end = 75.dp)
        )

        IconButton(
            onClick = { /*TODO*/ },
            modifier=Modifier
                .height(65.dp)
                .width(75.dp)
        ) {
            Icon(Icons.Default.Send,
                null,
                modifier = Modifier
                    .height(65.dp)
                    .width(75.dp)
            )

        }
    }

}