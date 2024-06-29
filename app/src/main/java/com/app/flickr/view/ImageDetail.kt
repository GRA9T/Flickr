package com.app.flickr.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.app.flickr.model.Image
import com.app.flickr.FontSizeManager
import org.jsoup.Jsoup
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ImageDetail(image: Image) {
    val fontSize by FontSizeManager.fontSize
    val description = Jsoup.parse(image.description).text()
    val author = Jsoup.parse(image.author).text()

    val publishedDate = try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = inputFormat.parse(image.published)
        outputFormat.format(date)
    } catch (e: Exception) {
        image.published
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = image.media.m),
            contentDescription = image.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .semantics { contentDescription = "Image of ${image.title}" }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(
                text = "Title: ",
                fontWeight = FontWeight.Bold,
                fontSize = fontSize,
                modifier = Modifier.semantics { contentDescription = "Title Label" }
            )
            Text(
                text = image.title,
                fontSize = fontSize,
                modifier = Modifier.semantics { contentDescription = "Title: ${image.title}" }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                text = "Description: ",
                fontWeight = FontWeight.Bold,
                fontSize = fontSize,
                modifier = Modifier.semantics { contentDescription = "Description Label" }
            )
            Text(
                text = description,
                fontSize = fontSize,
                modifier = Modifier.semantics { contentDescription = "Description: $description" }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                text = "Author: ",
                fontWeight = FontWeight.Bold,
                fontSize = fontSize,
                modifier = Modifier.semantics { contentDescription = "Author Label" }
            )
            Text(
                text = author,
                fontSize = fontSize,
                modifier = Modifier.semantics { contentDescription = "Author: $author" }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                text = "Published: ",
                fontWeight = FontWeight.Bold,
                fontSize = fontSize,
                modifier = Modifier.semantics { contentDescription = "Published Label" }
            )
            Text(
                text = publishedDate,
                fontSize = fontSize,
                modifier = Modifier.semantics { contentDescription = "Published: $publishedDate" }
            )
        }
    }
}
