package likco.myspeech.utils

import androidx.compose.material.ScaffoldState
import androidx.compose.ui.focus.FocusManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import likco.myspeech.App

typealias OnError = (Throwable) -> Unit

fun onError(scope: CoroutineScope, scaffoldState: ScaffoldState, focusManager: FocusManager): OnError =
    { error: Throwable ->
        scope.launch {
            focusManager.clearFocus()
            delay(50L)
            scaffoldState.snackbarHostState.showSnackbar(error.message ?: "Unknown error occurred")
        }
    }

fun Result<*>.catch() = onFailure(App.onError)
inline fun <T, R> T.catching(block: T.() -> R) = runCatching(block).catch()