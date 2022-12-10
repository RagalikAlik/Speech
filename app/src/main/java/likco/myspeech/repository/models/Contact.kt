package likco.myspeech.repository.models

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import likco.myspeech.App
import likco.myspeech.R


@Composable
fun Contact(imageId: Int, login:String)= Row(
    modifier= Modifier
        .fillMaxWidth()
        .height(50.dp)
        .padding(bottom = 10.dp),


    ) {
    Image(
        bitmap = ImageBitmap.imageResource(imageId) ,
        contentDescription = "photo",
    )

    Text(
        text = login,
        fontSize = 20.sp,
//        modifier = Modifier
//            .fillMaxWidth()
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