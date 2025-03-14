//package com.example.babyfon
//
//import android.content.Context
//import androidx.compose.foundation.layout.Column
//import androidx.compose.material3.Text
//import androidx.compose.material3.Button
//import androidx.compose.runtime.*
//import androidx.compose.ui.platform.LocalContext
//import androidx.media3.common.MediaItem
//import androidx.media3.exoplayer.ExoPlayer
//
//@Composable
//fun AudioPlayer(audioResId: Int) {
//    val context = LocalContext.current
//    var isPlaying by remember { mutableStateOf(false) }
//    val exoPlayer = remember { ExoPlayer.Builder(context).build() }
//
//    DisposableEffect(Unit) {
//        val mediaItem = MediaItem.fromRawResourceId(audioResId)
//        exoPlayer.setMediaItem(mediaItem)
//        exoPlayer.prepare()
//        onDispose {
//            exoPlayer.release()
//        }
//    }
//
//    Column {
//        Button(onClick = {
//            if (isPlaying) {
//                exoPlayer.pause()
//            } else {
//                exoPlayer.play()
//            }
//            isPlaying = !isPlaying
//        }) {
//            Text(if (isPlaying) "Pause" else "Play")
//        }
//    }
//}