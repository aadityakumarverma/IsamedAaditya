package com.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.os.Bundle
import com.isamed.databinding.ActivityTestResultDetailsBinding

import com.ui.fragments.*


class TestResultDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityTestResultDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityTestResultDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }


    }
}