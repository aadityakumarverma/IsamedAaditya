package com.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.isamed.databinding.ActivityAppointmentDetailsBinding
import com.isamed.databinding.ActivityFilterBinding

class AppointmentDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAppointmentDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAppointmentDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }


    }
}