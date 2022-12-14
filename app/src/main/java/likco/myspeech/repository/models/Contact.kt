package likco.myspeech.repository.models

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import likco.myspeech.R

@Composable
fun Contact(login:String)= Row(
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

    IconButton(
        onClick = {

        },
    ) {
        Icon(
            Icons.Default.Menu,
            null
        )
    }
}