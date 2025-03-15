package com.example.babyfon

import android.content.ContentResolver
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.babyfon.ui.theme.BabyFonTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class MainActivity : ComponentActivity() {

    private var isPlaying = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BabyFonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FilledButtonExample()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface (color = Color.Green) {
        Text(
            text = "Hello $name!",
            modifier = modifier.padding(24.dp),
        )
    }
}




@Preview(showBackground = true)
@Composable
fun FilledButtonExample() {
    val (value, setValue) = remember { mutableStateOf("Riproduci") }
    val player = ExoPlayer.Builder(LocalContext.current).build()
    val uri = Uri.Builder().scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
        .path(R.raw.sample.toString())
        .build()

    val mediaItem = MediaItem.fromUri(uri)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
    ) {
        Text(text = "Baby Fon", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 16.dp))
        Text("Play the audio")
        Spacer(modifier = Modifier.weight(1F))

        //var label = "Riproduci"
        Button(onClick = {
            if (!player.isPlaying) {
                // Set the media item to be played.
                player.setMediaItem(mediaItem)
                // Prepare the player.
                player.prepare()
                // Start the playback.
                player.play()
                setValue("Pausa")
            }
            if (player.isPlaying) {
                player.stop()
                setValue("Riproduci")
            }
        }) {
            Text(value)
        }
        Spacer(modifier = Modifier.weight(1F))
    }
}