package com.app.flickr.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.app.flickr.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    selectedImage: Any?,
    isSearchVisible: Boolean,
    onSearchVisibilityChanged: () -> Unit,
    onBackClick: () -> Unit,
    onSearch: (String) -> Unit,
    onFontSizeDialogClick: () -> Unit
) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (selectedImage != null) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.semantics { contentDescription = "Back Button" }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Image Details")
                } else {
                    if (isSearchVisible) {
                        SearchBar(
                            searchQuery = "",
                            onSearch = onSearch,
                            modifier = Modifier
                                .fillMaxWidth()
                                .semantics { contentDescription = "Search Bar" }
                        )
                    } else {
                        Text("Flickr Image Search")
                    }
                }
            }
        },
        actions = {
            if (selectedImage == null) {
                IconButton(
                    onClick = onSearchVisibilityChanged,
                    modifier = Modifier.semantics { contentDescription = "Search Button" }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
                        contentDescription = "Search"
                    )
                }
            }
            IconButton(
                onClick = onFontSizeDialogClick,
                modifier = Modifier.semantics { contentDescription = "Adjust Font Size Button" }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_accessibility),
                    contentDescription = "Adjust Font Size"
                )
            }
        }
    )
}
