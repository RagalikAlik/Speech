package likco.myspeech.repository.models

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp



@Composable
fun CreateMyMessage(message: String){
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .padding(start = 10.dp)
            .background(color = Color.Yellow)
    ) {
        Text(
            text=message,
            modifier = Modifier
                .width(250.dp)
                .padding(top=10.dp),
        )
    }
}

