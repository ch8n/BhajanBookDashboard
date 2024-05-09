package data.local.datasource

import DataResourceHelper
import com.google.gson.Gson
import data.local.models.HoroscopeItemDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HoroscopeDataSource {

    private val gson = Gson()

    suspend fun fromLocalFileSystemRepository(): List<HoroscopeItemDTO> = withContext(Dispatchers.IO) {
        try {
            val horoscopeFile = DataResourceHelper.getHoroscopeSourceFile()
            val horoscopeString = horoscopeFile.readText()
            val horoscopeItemsAny = gson.fromJson(horoscopeString, List::class.java)
            val horoscopeItems = horoscopeItemsAny.map {
                val json = gson.toJson(it)
                gson.fromJson(json, HoroscopeItemDTO::class.java)
            }
            horoscopeItems
        } catch (e: Exception) {
            println(e.stackTrace)
            listOf()
        }
    }
}