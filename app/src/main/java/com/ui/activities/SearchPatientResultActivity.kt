package com.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.isamed.databinding.ActivitySearchPatientResultBinding

class SearchPatientResultActivity : AppCompatActivity() {

    lateinit var pageInfo:String
    lateinit var binding: ActivitySearchPatientResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivitySearchPatientResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        pageInfo= intent.getStringExtra("page").toString()


        binding.ivBackButton.setOnClickListener {
            finish()
        }

        binding.ivSearchImg.setOnClickListener {
            binding.llGoneSearchBar.isVisible=true
        }
        binding.ivGoneCrossIcon.setOnClickListener {
            binding.llGoneSearchBar.isVisible=false
        }
        binding.ivGoneSearchIcon.setOnClickListener {
            Toast.makeText(this, "Searching...", Toast.LENGTH_SHORT).show()
        }

        binding.llSearchedPatient.setOnClickListener {
            if (pageInfo=="sonogramToFilter")
            {
                val intent = Intent(this@SearchPatientResultActivity, SonogramActivity::class.java)
                startActivity(intent)
            }
            else {
                val intent = Intent(this@SearchPatientResultActivity, PatientFullDetailsActivity::class.java)
                startActivity(intent)
            }

        }

    }
}