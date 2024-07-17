import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.cmaina.photos.App
import com.cmaina.photos.di.initKoin
import org.koin.core.Koin


lateinit var koin: Koin

fun main() {
    koin = initKoin().koin
    return application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Photos Desktop"
        ) {
            App()
        }

        LaunchedEffect(Unit){
            
        }
    }
}