package com.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isamed.databinding.ActivityLoginBinding
import com.isamed.databinding.ActivitySonogramBinding

class SonogramActivity : AppCompatActivity() {
    lateinit var binding: ActivitySonogramBinding
    var flagGo=0
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivitySonogramBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }

    }
}