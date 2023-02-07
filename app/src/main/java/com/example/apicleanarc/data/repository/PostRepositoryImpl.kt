package com.example.apicleanarc.data.repository

import com.example.apicleanarc.data.api.PostApi
import com.example.apicleanarc.data.model.Post
import com.example.apicleanarc.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: PostApi
):PostRepository {
    override suspend fun getPosts(): List<Post> {
        return api.getPosts().body()!!
    }
}