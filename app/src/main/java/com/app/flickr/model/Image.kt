package com.app.flickr.model

data class Image(
    val title: String,
    val link: String,
    val media: Media,
    val description: String,
    val author: String,
    val published: String
)

