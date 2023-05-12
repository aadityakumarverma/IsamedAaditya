package com.ui.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.InputFilter
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.isamed.R
import com.isamed.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    var flagGo=0
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.tvForgotPassword.setOnClickListener {
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }


        val maxUserNameLength =30
        binding.etUserName.filters= arrayOf<InputFilter>(InputFilter.LengthFilter(maxUserNameLength))

        val maxPasswordLength =30
        binding.etPassword.filters= arrayOf<InputFilter>(InputFilter.LengthFilter(maxPasswordLength))


       /* binding.cbTerms.setOnClickListener {

        }*/


        binding.etUserName.doOnTextChanged { text, start, before, count ->
            funValidateUserName()
        }
        binding.etPassword.doOnTextChanged { text, start, before, count ->
            funValidatePassword()
        }

        binding.btnLogin.setOnClickListener{
            funValidateLogin()
        }

        binding.tvTerms.setOnClickListener {
            val intent= Intent(this@LoginActivity,TermsActivity::class.java)
            startActivity(intent)
        }

    }




    private fun funValidateUserName() {



        if (binding.etUserName.text.toString().isEmpty())
        {binding.vUserNameEms.setBackgroundColor(Color.parseColor("#d71f2b"))
            binding.tvValidateUserName.isVisible=true
            binding.tvValidateUserName.text="*Please enter your username"

        }
        else if(binding.etUserName.text.contains(" "))
        {
            binding.vUserNameEms.setBackgroundColor(Color.parseColor("#d71f2b"))
            binding.tvValidateUserName.isVisible=true
            binding.tvValidateUserName.text="*Space is not Allowed"
        }
        else if (binding.etUserName.text.toString().length<6)
        {binding.vUserNameEms.setBackgroundColor(Color.parseColor("#d71f2b"))
            binding.tvValidateUserName.isVisible=true
            binding.tvValidateUserName.text="*Please enter atleast 6 characters"
        }
        else if (binding.etUserName.text.toString().length>30)
        {binding.vUserNameEms.setBackgroundColor(Color.parseColor("#d71f2b"))
            binding.tvValidateUserName.isVisible=true
            binding.tvValidateUserName.text="*Maximum 30 characters"
        }

        else
        {
            binding.vUserNameEms.setBackgroundColor(Color.parseColor("#2742b4"))
            binding.tvValidateUserName.isVisible=false
            flagGo++
        }
    }


    private fun funValidatePassword() {


        if (binding.etPassword.text.toString().isEmpty())
        {binding.vPasswordEms.setBackgroundColor(Color.parseColor("#d71f2b"))
            binding.tvValidatePassword.isVisible=true
            binding.tvValidatePassword.text="*Please enter your password."

        }
        else if(binding.etPassword.text.contains(" "))
        {binding.vPasswordEms.setBackgroundColor(Color.parseColor("#d71f2b"))
            binding.tvValidatePassword.isVisible=true
            binding.tvValidatePassword.text="*Space is not allowed."
        }
        else if (binding.etPassword.text.toString().length<6)
        {binding.vPasswordEms.setBackgroundColor(Color.parseColor("#d71f2b"))
            binding.tvValidatePassword.isVisible=true
            binding.tvValidatePassword.text="*Please enter atleast 6 characters."
        }
        else if (binding.etPassword.text.toString().length>30)
        {binding.vPasswordEms.setBackgroundColor(Color.parseColor("#d71f2b"))
            binding.tvValidatePassword.isVisible=true
            binding.tvValidatePassword.text="*Maximum 30 characters."
        }

        else
        {
            binding.vPasswordEms.setBackgroundColor(Color.parseColor("#2742b4"))
            binding.tvValidatePassword.isVisible=false
            flagGo++
        }
    }

    private fun funValidateCheckBoxTerms() {


        if (binding.cbTerms.isChecked)
        {flagGo++

        }
        else if (!binding.cbTerms.isChecked && binding.etUserName.text.isNotEmpty() && binding.etPassword.text.isNotEmpty())
        {
            funOpenWarningPopup(binding.btnLogin,"Please check terms and conditions.")
        }
    }
    fun funOpenWarningPopup(view: View?, msg : String) {


        // step 1
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.layout_popup_alert, null)

        var txtView: TextView = popupView.findViewById(R.id.tv_popupMsg)
        var okBtnTxt: TextView = popupView.findViewById(R.id.tv_doneBtn)



        txtView.text=msg
        // step 2
        val wid = LinearLayout.LayoutParams.WRAP_CONTENT
        val high = LinearLayout.LayoutParams.WRAP_CONTENT
        val focus= true
        val popupWindow = PopupWindow(popupView, wid, high, focus)

        // step 3
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
        okBtnTxt.setOnClickListener {
            popupWindow.dismiss()
        }

    }

    private fun funValidateLogin() {

        var msg="Something went wrong!!"
        flagGo=0
        funValidateUserName()
        funValidatePassword()
        funValidateCheckBoxTerms()
        if (flagGo == 3) {
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            finish()
            startActivity(intent)

        }


    }



}