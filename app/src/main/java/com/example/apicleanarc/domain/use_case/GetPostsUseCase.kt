package com.example.apicleanarc.domain.use_case

import com.example.apicleanarc.data.model.Post
import com.example.apicleanarc.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke(): Flow<List<Post>> = flow {
        val posts = repository.getPosts()
        emit(posts)
    }
}