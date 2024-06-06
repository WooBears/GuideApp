package com.example.guideapp.presentation.ui

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.guideapp.R
import com.example.guideapp.databinding.ActivityGuideDetailBinding

class GuideDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuideDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuideDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val url = intent.getStringExtra("url")
        if (url != null) {

        }
    }
}