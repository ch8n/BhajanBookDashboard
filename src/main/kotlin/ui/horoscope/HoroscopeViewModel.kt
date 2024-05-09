package ui.horoscope

import DataResourceHelper
import data.local.datasource.HoroscopeDataSource
import data.local.models.HoroscopeItemDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.*
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random


data class HoroscopeListItemUIState(
    val id: Int,
    val dateGroup: String,
    val imageUrl: String,
    val name: String,
    val sheetName: String
) {
    companion object {
        fun random() = HoroscopeListItemUIState(
            id = Random.nextInt(),
            dateGroup = "disputationi",
            imageUrl = "https://duckduckgo.com/?q=dicam",
            name = "Rochelle Ingram ${UUID.randomUUID()}",
            sheetName = "Jannie Snow "
        )
    }
}

data class HoroscopeScreenState(
    val horoscopes: List<HoroscopeListItemUIState>
) {
    companion object {
        val EMPTY = HoroscopeScreenState(emptyList())
    }
}


class HoroscopeViewModel(
    private val horoscopeDataSource: HoroscopeDataSource,
) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + SupervisorJob()

    val state = MutableStateFlow<HoroscopeScreenState>(HoroscopeScreenState.EMPTY)

    fun loadHoroscope() {
        launch {
            val horoscope = horoscopeDataSource.fromLocalFileSystemRepository()
            val horoscopeUIState = horoscope.map { it.toUiState() }
            state.update {
                it.copy(horoscopes = horoscopeUIState)
            }
        }
    }

    inline fun HoroscopeItemDTO.toUiState(): HoroscopeListItemUIState {
        return HoroscopeListItemUIState(
            id = this.id ?: -1,
            dateGroup = this.dateGroup ?: "",
            imageUrl = DataResourceHelper.dataSourceResourcePath + "/${this.imageUrl ?: ""}",
            name = this.name ?: "",
            sheetName = this.sheetName ?: ""
        )
    }


}