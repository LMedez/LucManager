package com.luc.manager.ui.views.panel

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.luc.common.model.SongMetadata
import com.luc.manager.ui.views.widget.CircularIndeterminateProgressBar
import com.luc.manager.ui.views.widget.Snackbar
import com.luc.manager.ui.views.widget.TextField
import com.luc.presentation.MusicDataViewModel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MusicDataComponent : KoinComponent {
    private val musicDataViewModel by inject<MusicDataViewModel>()
    fun musicDataViewModel() = musicDataViewModel
}

@Composable
fun RhcpAppPanel() {
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        Row {
            MenuPanel()
            AddDataPanel()
        }
    }
}

@Composable
fun AddDataPanel() {
    var dataType by remember { mutableStateOf("") }
    val successfullyAdded by MusicDataComponent().musicDataViewModel().successfullyAdded.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            OutlinedButton(
                onClick = { dataType = DataType.SONGMETADATA.name },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Icon(
                    Icons.Filled.Add,
                    "contentDescription"
                )
                Text("SONG METADATA")
            }

            OutlinedButton(onClick = { dataType = DataType.ALBUMMETADATA.name }) {
                Icon(
                    Icons.Filled.Add,
                    "contentDescription"
                )
                Text("ALBUM METADATA")
            }
        }

        if (dataType == DataType.SONGMETADATA.name)
            SongMetadataForm()

       Snackbar(successfullyAdded)
    }
}

@Composable
fun MenuPanel() {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxHeight()) {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Filled.Add,
                    "contentDescription"
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    Icons.Filled.Add,
                    "contentDescription"
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    Icons.Filled.Add,
                    "contentDescription"
                )
            }
        }
    }
}

@Composable
fun SongMetadataForm() {
    var songMetadata by remember { mutableStateOf(SongMetadata()) }
    val isFetching by MusicDataComponent().musicDataViewModel().isFetching.collectAsState()
    val scope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(modifier = Modifier.padding(8.dp), "Song Name") {
            songMetadata = songMetadata.copy(title = it)
        }

        TextField(modifier = Modifier.padding(8.dp), "Album Name") {
            songMetadata = songMetadata.copy(albumName = it)
        }

        TextField(modifier = Modifier.padding(8.dp), "Artist") {
            songMetadata = songMetadata.copy(artist = it)
        }

        TextField(modifier = Modifier.padding(8.dp), "Image Url") {
            songMetadata = songMetadata.copy(imageUrl = it)
        }

        TextField(modifier = Modifier.padding(8.dp), "Source mp3") {
            songMetadata = songMetadata.copy(source = it)
        }

        TextField(modifier = Modifier.padding(8.dp), "Track Number") {
            songMetadata = songMetadata.copy(trackNumber = it.toLong())
        }

        TextField(modifier = Modifier.padding(8.dp), "Song Duration") {
            songMetadata = songMetadata.copy(songDuration = it)
        }

        Button(onClick = {
            scope.launch {
                MusicDataComponent().musicDataViewModel().addSongMetadata(songMetadata)
            }

        }) {
            Text("SAVE")
        }

        CircularIndeterminateProgressBar(isFetching)

    }
}

enum class DataType {
    SONGMETADATA,
    ALBUMMETADATA
}
