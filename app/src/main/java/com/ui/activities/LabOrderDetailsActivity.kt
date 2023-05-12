package com.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.isamed.databinding.ActivityLabOrderDetailsBinding

class LabOrderDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityLabOrderDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLabOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }

    }
}
