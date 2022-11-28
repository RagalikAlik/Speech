package likco.myspeech.ui.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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

@Composable
fun ProfileScreen(state: MutableState<Fragments>)=Column(
    modifier = Modifier
    .fillMaxWidth()
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    )   {
            Column (modifier = Modifier
                .background(Color.White)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,

                content = {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.empty_profile_picture) ,
                        contentDescription = "profile" )

                    Text(text =App.user?.login ?: "",fontSize = 20.sp)
                          }
                )
            
        }   

}