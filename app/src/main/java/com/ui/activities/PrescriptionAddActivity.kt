package com.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.isamed.databinding.ActivityPrescriptionAddBinding


class PrescriptionAddActivity : AppCompatActivity() {
    lateinit var binding: ActivityPrescriptionAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrescriptionAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }
        binding.btnSubmit.setOnClickListener {
            Toast.makeText(this, ""+"Submitted", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}