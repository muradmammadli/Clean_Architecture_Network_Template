package com.example.apicleanarc.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.apicleanarc.R
import com.example.apicleanarc.databinding.ActivityMainBinding
import com.example.apicleanarc.presentation.adapter.PostAdapter
import com.example.apicleanarc.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.post.observe(this) {
            postAdapter = PostAdapter(it)
            binding.recyclerView.adapter = postAdapter
            it.forEach {
                Log.d("jadhfjkakdf", it.title)
            }
        }
    }
}