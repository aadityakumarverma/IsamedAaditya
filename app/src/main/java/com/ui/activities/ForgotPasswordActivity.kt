package com.ui.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.InputFilter
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.isamed.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var binding: ActivityForgotPasswordBinding
    var flagGo=0
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityForgotPasswordBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val maxEmailLength =50
        binding.etEmail.filters= arrayOf<InputFilter>(InputFilter.LengthFilter(maxEmailLength))

        binding.etEmail.doOnTextChanged { text, start, before, count ->
            funValidateEmail()
        }

        binding.ivBackButton.setOnClickListener {
            finish()
        }

        binding.btnSubmit.setOnClickListener {
            funValidate()
        }



    }

    private fun funValidate() {
        flagGo=0
        funValidateEmail()
        if (flagGo == 1) {

            val intent = Intent(this@ForgotPasswordActivity, LoginActivity::class.java)
            finishAffinity()
            startActivity(intent)

        }
    }

    private fun funValidateEmail() {
        if (binding.etEmail.text.toString().isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches())
        {binding.vEmailEms.setBackgroundColor(Color.parseColor("#d71f2b"))
            binding.tvValidateEmail.isVisible=true
            binding.tvValidateEmail.text="*Please enter valid email."

        }
        else
        {
            binding.vEmailEms.setBackgroundColor(Color.parseColor("#2742b4"))
            binding.tvValidateEmail.isVisible=false
            flagGo++

        }
    }
}