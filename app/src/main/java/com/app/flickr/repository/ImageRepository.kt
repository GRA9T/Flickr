package com.app.flickr.repository

import com.app.flickr.model.Image
import com.app.flickr.network.RetrofitInstance

class ImageRepository {

    private val api = RetrofitInstance.api

    suspend fun searchImages(query: String): List<Image> {
        val response = api.searchImages(query)
        return response.items
    }
}