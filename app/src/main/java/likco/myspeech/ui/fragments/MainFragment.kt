package likco.myspeech.ui.fragments

import android.annotation.SuppressLint
import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import likco.myspeech.App
import likco.myspeech.R
import likco.myspeech.ui.Fragments
import likco.myspeech.utils.catching
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(state: MutableState<Fragments>) = Column(
    verticalArrangement = Arrangement.Center
) {

    MyScaffold(state)

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyScaffold(state: MutableState<Fragments>) {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = colorResource(id = R.color.purple_200),
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = scope) },
        drawerContent = { MyColumn(state) },
        content = {
            MyRow()
        }
    )
}

@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    val drawerState = scaffoldState.drawerState

    TopAppBar(
        title = {
            Text(
                text = "Speech",
                color = Color.White,
                modifier = Modifier.padding(horizontal = 60.dp)
            )
        },
        backgroundColor = colorResource(id = R.color.purple_200)
    )
}

@Composable
fun MyRow() {


}

@Composable
fun MyColumn(state: MutableState<Fragments>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .weight(1.5f),
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            state.value = Fragments.PROFILE
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 25.dp)
                    ) {
                        Text(text = "Profile")
                    }

                    Button(
                        onClick = {
                            state.value = Fragments.MAIN
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 25.dp)
                    ) {
                        Text(text = "Main Page")
                    }
                }

            }
        )
        Box(modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .weight(1f))
        Box(modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .weight(1f))
        Box(modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .weight(1f))
        Box(modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .height(75.dp),
            content = {
                Button(
                    onClick = {
                        state.value = Fragments.SETTINGS
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                ) {
                    Text(text = "Settings")
                }
            }
        )
    }


}




