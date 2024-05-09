import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.ch_n.BhajanBookDashboard.BuildConfig
import org.eclipse.jgit.api.Git
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider
import ui.horoscope.HoroscopeScreen
import java.io.File


object DataResourceHelper {

    val dataSourcePath = "src/main/resources/datasource"
    val dataSourceResourcePath = "$dataSourcePath/resource"
    val dataSourceHoroscopePath = "src/main/resources/datasource/zodiac-v1.json"

    fun getDataSourceRootFile(): File {
        return File(dataSourcePath)
    }

    fun getHoroscopeSourceFile(): File {
        return File(dataSourceHoroscopePath)
    }
}


suspend fun initRepository() {
    val resourcePath = File("src/main/resources")
    if (resourcePath.exists()) {
        val datasource = File(resourcePath.path + "/datasource")
        if (datasource.exists().not()) datasource.mkdirs()
        if (datasource.length() == 0L) {
            Git.cloneRepository()
                .setURI(BuildConfig.Github_Datasource_Repository_URL)
                .setDirectory(datasource)
                .setCredentialsProvider(UsernamePasswordCredentialsProvider(BuildConfig.Github_Access_Token, ""))
                .call()
        }
    }
}


@Composable
@Preview
fun App() {

    MaterialTheme {
        HoroscopeScreen()
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
