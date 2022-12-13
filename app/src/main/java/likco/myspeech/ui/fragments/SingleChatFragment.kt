package likco.myspeech.ui.fragments

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import likco.myspeech.repository.models.CreateMyMessage
import likco.myspeech.ui.Fragments
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import likco.myspeech.repository.DataBaseRepository

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun SingleChatScreen(state: MutableState<Fragments>,messageFrom:String, messageTo: String)= Column(
    modifier = Modifier
        .fillMaxWidth(),

    ) {
    var message by remember {
        mutableStateOf("")
    }

    TopAppBar {

        IconButton(onClick = {
            state.value = Fragments.MAIN
        }) {
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

    val messages = mutableStateListOf("speech", "huinya")

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        horizontalAlignment = Alignment.End,

        ){
        items(messages) {
            CreateMyMessage(message = it)
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom

    ) {
        OutlinedTextField(
            value = message,
            onValueChange = {message = it},
            label = { Text(text = "Message ") },
            modifier=Modifier.width(345.dp)
        )

        val db: FirebaseFirestore= FirebaseFirestore.getInstance()
        val dab= DataBaseRepository(db)

        val context = LocalContext.current
        IconButton(
            onClick = {

                Toast.makeText(context, "сообщение не отправляется, иди нахуй", Toast.LENGTH_SHORT).show()
                messages.add(message)

            },
            modifier= Modifier
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

fun sendMessage(text: String){





}
