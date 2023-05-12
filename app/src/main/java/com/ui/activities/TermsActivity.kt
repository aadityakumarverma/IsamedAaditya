package com.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isamed.R
import com.isamed.databinding.ActivityContactUsBinding
import com.isamed.databinding.ActivityTermsBinding

class TermsActivity : AppCompatActivity() {
    lateinit var binding: ActivityTermsBinding
    var flagGo=0
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityTermsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }




    }
}