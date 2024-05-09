package ui.horoscope

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.local.datasource.HoroscopeDataSource
import ui.horoscope.components.HoroscopeItem


@Composable
fun HoroscopeScreen() {
    val horoscopeDataSource = remember { HoroscopeDataSource() }
    val horoscopeViewModel = remember { HoroscopeViewModel(horoscopeDataSource) }
    val horoscopeScreenState by horoscopeViewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        horoscopeViewModel.loadHoroscope()
    }
    HoroscopeScreenContent(horoscopeScreenState)
}


@Preview
@Composable
fun HoroscopeScreenContent(
    screenState: HoroscopeScreenState
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            text = "Horoscope Manager",
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(screenState.horoscopes) { item ->
                HoroscopeItem(item)
            }
        }
    }
}

