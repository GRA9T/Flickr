package com.app.flickr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.app.flickr.ui.theme.FlickrSearchAppTheme
import com.app.flickr.viewmodel.ImageViewModel
import com.app.flickr.view.FlickrApp

class MainActivity : ComponentActivity() {
    private val viewModel: ImageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlickrSearchAppTheme {
                FlickrApp(viewModel)
            }
        }
    }
}
