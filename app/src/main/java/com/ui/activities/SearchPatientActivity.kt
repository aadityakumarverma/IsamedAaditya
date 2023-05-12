package com.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import com.isamed.R
import com.isamed.databinding.ActivitySearchPatientBinding

class SearchPatientActivity : AppCompatActivity() {
    var flagGo=0
    lateinit var binding: ActivitySearchPatientBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchPatientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }
        binding.tvSearch.setOnClickListener {
            /*Toast.makeText(this, ""+binding.tvSearch.text+"ing...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SearchPatientActivity,SearchPatientResultActivity::class.java)
            startActivity(intent)*/
            funValidateSearch()
        }
    }



    private fun funValidateSearch() {


        if (binding.etFirstName.text.isNotEmpty() && binding.etLastName.text.isNotEmpty()) {

            val intent = Intent(this@SearchPatientActivity, SearchPatientResultActivity::class.java)
            finish()
            startActivity(intent)

        }
        else{
            funOpenWarningPopup(binding.etFirstName,"Please fill mandatory fields.")
        }


    }

    fun funOpenWarningPopup(view: View?, msg: String) {


        // step 1
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.layout_popup_alert, null)

        var txtView: TextView = popupView.findViewById(R.id.tv_popupMsg)
        var okBtnTxt: TextView = popupView.findViewById(R.id.tv_doneBtn)



        txtView.text = msg
        // step 2
        val wid = LinearLayout.LayoutParams.WRAP_CONTENT
        val high = LinearLayout.LayoutParams.WRAP_CONTENT
        val focus = true
        val popupWindow = PopupWindow(popupView, wid, high, focus)
        popupWindow.dismiss()

        // step 3
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
        okBtnTxt.setOnClickListener {
            popupWindow.dismiss()
        }

    }


}