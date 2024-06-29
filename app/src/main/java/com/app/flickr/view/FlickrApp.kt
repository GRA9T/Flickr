package com.app.flickr.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.app.flickr.viewmodel.ImageViewModel

@Composable
fun FlickrApp(viewModel: ImageViewModel) {
    val images by viewModel.images.observeAsState(emptyList())
    val isLoading by viewModel.isLoading.observeAsState(false)
    val selectedImage by viewModel.selectedImage.observeAsState()
    val searchQuery = remember { mutableStateOf("") }
    var isSearchVisible by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            AppBar(
                selectedImage = selectedImage,
                isSearchVisible = isSearchVisible,
                onSearchVisibilityChanged = { isSearchVisible = !isSearchVisible },
                onBackClick = { viewModel.clearSelectedImage() },
                onSearch = { query ->
                    searchQuery.value = query
                    viewModel.searchImages(query)
                },
                onFontSizeDialogClick = { showDialog = true }
            )
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    when {
                        selectedImage != null -> ImageDetail(selectedImage!!)
                        isLoading -> LoadingIndicator()
                        else -> ImageGrid(images) { image ->
                            viewModel.selectImage(image)
                        }
                    }
                }
                if (showDialog) {
                    FontSizeDialog(onDismiss = { showDialog = false })
                }
            }
        }
    )
}
