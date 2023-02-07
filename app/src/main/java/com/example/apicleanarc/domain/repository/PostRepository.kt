package com.example.apicleanarc.domain.repository

import com.example.apicleanarc.data.model.Post

interface PostRepository {
    suspend fun getPosts():List<Post>
}