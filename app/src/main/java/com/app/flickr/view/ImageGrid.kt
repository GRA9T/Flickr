package com.app.flickr.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.app.flickr.model.Image

@Composable
fun ImageGrid(images: List<Image>, onImageClick: (Image) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(images) { image ->
            ImageItem(image = image, onClick = { onImageClick(image) })
        }
    }
}

@Composable
fun ImageItem(image: Image, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .aspectRatio(1f) // Ensures the item is a square
            .fillMaxSize()
            .semantics { contentDescription = "Image Item: ${image.title}" }
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = image.media.m),
            contentDescription = image.title,
            contentScale = ContentScale.Crop, // Ensures the image fills the box without white spaces
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() }
        )
    }
}
