package com.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.isamed.databinding.ActivityPaymentDetailsBinding

class PaymentDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityPaymentDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityPaymentDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.ivBackButton.setOnClickListener {
            finish()
        }

    }
}