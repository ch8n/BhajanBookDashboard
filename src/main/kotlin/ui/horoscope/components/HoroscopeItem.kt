package ui.horoscope.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.kamel.core.utils.File
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.*
import ui.horoscope.HoroscopeListItemUIState

@Composable
fun HoroscopeItem(
    horoscopeListItem: HoroscopeListItemUIState
) {

    var _horoscopeListItem by remember(horoscopeListItem) { mutableStateOf(horoscopeListItem) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.DarkGray)
            .padding(vertical = 8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(0.6f).align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(0.3f).fillMaxHeight(0.3f).border(1.dp,Color.DarkGray)
            ) {
                // image
                val asyncPainter = asyncPainterResource(
                    data = File(_horoscopeListItem.imageUrl)
                )
                KamelImage(
                    resource = asyncPainter,
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = _horoscopeListItem.id.toString(),
                    onValueChange = {
                        if (it.toIntOrNull() != null) {
                            _horoscopeListItem = _horoscopeListItem.copy(id = it.toInt())
                        }
                    },
                    placeholder = {
                        Text("Horoscope Id")
                    },
                )

                OutlinedTextField(
                    value = _horoscopeListItem.name,
                    onValueChange = {
                        _horoscopeListItem = _horoscopeListItem.copy(name = it)
                    },
                    placeholder = {
                        Text("Horoscope Name")
                    }
                )

                OutlinedTextField(
                    value = _horoscopeListItem.dateGroup,
                    onValueChange = {
                        _horoscopeListItem = _horoscopeListItem.copy(dateGroup = it)
                    },
                    placeholder = {
                        Text("Horoscope Date Start")
                    }
                )

                OutlinedTextField(
                    value = _horoscopeListItem.sheetName,
                    onValueChange = {
                        _horoscopeListItem = _horoscopeListItem.copy(sheetName = it)
                    },
                    placeholder = {
                        Text("Horoscope SheetName")
                    }
                )
            }
        }
    }

}