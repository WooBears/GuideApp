package com.example.guideapp.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guideapp.R
import com.example.guideapp.databinding.ActivityMainBinding
import com.example.guideapp.domain.adapter.GuideAdapter
import com.example.guideapp.presentation.viewmodel.GuidViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: GuidViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val adapter = GuideAdapter()
        binding.rvRecycler.adapter = adapter
        binding.rvRecycler.layoutManager = LinearLayoutManager(this)

        viewModel.getGuide()

        setupLazyLoading()

    }

    private fun setupLazyLoading() {
        binding.rvRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

                if (lastVisibleItemPosition + 3 >= totalItemCount) {
                    viewModel.getGuide()
                }
            }
        })
    }
}