package likco.myspeech.ui.fragments

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import likco.myspeech.R
import likco.myspeech.ui.Fragments

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
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = scope, state) },
        drawerContent = { MyColumn(state) },
        content = {
            MyRow()
            Button(onClick = { state.value=Fragments.SINGLECHATFRAGMENT }) {
                
            }
        }
    )
}

@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope, state: MutableState<Fragments>) {
    val drawerState = scaffoldState.drawerState

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {  }) {
                Icon(Icons.Default.Home,
                    null,
                    modifier = Modifier
                        .background(Color(1, 1,1))

                )
            }
        },
        title = {
            Text(
                text = "Speech",
                color = White,
                modifier = Modifier.padding(horizontal = 30.dp)
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
            .background(White)
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
                            state.value = Fragments.CONTACTS
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 25.dp)
                    ) {
                        Text(text = "Контакты")
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
            .background(White)
            .fillMaxWidth()
            .weight(1f))

        Box(modifier = Modifier
            //.background(Color.Blue)
            .background(White)
            .fillMaxWidth()
            .weight(1f))

        Box(modifier = Modifier
            //.background(Color.Red)
            // .background(Color.White)
            .fillMaxWidth()
            .weight(1f))

        Box(modifier = Modifier
            .background(White)
            .fillMaxWidth()
            .height(75.dp),
            content = {
                Button(
                    onClick = {
                        state.value = Fragments.SETTINGS
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp),

                ) {
                    Row(
                        modifier= Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        Icon(Icons.Default.Settings,
                            null
                        )
                        Text(text = "Settings", textAlign = TextAlign.Start)
                    }

                }
            }
        )
    }


}




