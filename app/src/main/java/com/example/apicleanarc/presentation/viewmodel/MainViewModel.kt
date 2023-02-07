package com.example.apicleanarc.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicleanarc.data.model.Post
import com.example.apicleanarc.domain.use_case.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val post:LiveData<List<Post>> = _posts

    init {
        getPosts()
    }

    private fun getPosts(){
        getPostsUseCase().onEach {results->
            _posts.value = results
        }.launchIn(viewModelScope)

    }


}