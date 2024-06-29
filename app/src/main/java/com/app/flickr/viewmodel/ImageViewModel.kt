package com.app.flickr.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.flickr.model.Image
import com.app.flickr.repository.ImageRepository
import kotlinx.coroutines.launch

class ImageViewModel : ViewModel() {

    private val _images = MutableLiveData<List<Image>>()
    val images: LiveData<List<Image>> = _images

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _selectedImage = MutableLiveData<Image?>()
    val selectedImage: LiveData<Image?> = _selectedImage

    private val repository = ImageRepository()

    fun searchImages(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = repository.searchImages(query)
            _images.postValue(result)
            _isLoading.value = false
        }
    }

    fun selectImage(image: Image) {
        _selectedImage.value = image
    }

    fun clearSelectedImage() {
        _selectedImage.value = null
    }
}
