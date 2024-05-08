import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.ch_n.BhajanBookDashboard.BuildConfig
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.eclipse.jgit.api.Git
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider
import java.io.File


/**
 * Data source repo -
 */

suspend fun initRepository() {
    val resourcePath = File("src/main/resources")
    if (resourcePath.exists()){
        val datasource = File(resourcePath.path+"/datasource")
        if (datasource.exists().not()) datasource.mkdirs()
        if (datasource.length() == 0L){
            Git.cloneRepository()
                .setURI(BuildConfig.Github_Datasource_Repository_URL)
                .setDirectory(datasource)
                .setCredentialsProvider(UsernamePasswordCredentialsProvider(BuildConfig.Github_Access_Token,""))
                .call()
        }
    }
}


@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
