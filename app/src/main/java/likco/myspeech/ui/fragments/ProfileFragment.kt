package likco.myspeech.ui.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.imageResource

import likco.myspeech.App
import likco.myspeech.R
import likco.myspeech.ui.Fragments

@Composable
fun ProfileScreen(state: MutableState<Fragments>)=Column(
    modifier = Modifier
    .fillMaxWidth()
) {
    Column(
        modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.empty_profile_picture) ,
            contentDescription = "profile" )

        Text(text = App.user?.login ?: "")
    }

}