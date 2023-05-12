package com.ui.activities

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.isamed.R
import com.isamed.databinding.ActivityFilterFromAppointmentBinding
import java.text.SimpleDateFormat
import java.util.*

class FilterFromAppointmentActivity : AppCompatActivity() {
    var button_date: Button? = null
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()

    lateinit var binding: ActivityFilterFromAppointmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterFromAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }
        binding.tvDone.setOnClickListener {
            funValidateSearch()
        }


        ///////////////////////

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateStartDate()
            }
        }

        val dateSetListener2 = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateEndDate()
            }
        }
        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        binding.tvStartDate!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    this@FilterFromAppointmentActivity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

        })
        binding.tvEndDate!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    this@FilterFromAppointmentActivity,
                    dateSetListener2,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

        })
        /////////////////////////

    }

    private fun updateDateStartDate() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        binding.tvStartDate!!.text = sdf.format(cal.getTime())
    }

    private fun updateDateEndDate() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        binding.tvEndDate!!.text = sdf.format(cal.getTime())
    }


    private fun funValidateSearch() {

//        Please fill mandatory fields
        if (binding.etFirstName.text.isNotEmpty() && binding.etLastName.text.isNotEmpty() &&
            binding.etAccountNumber.text.isNotEmpty() && binding.etSSN.text.isNotEmpty() && binding.etProvider.text.isNotEmpty()
            && binding.etLocation.text.isNotEmpty() && binding.etPractice.text.isNotEmpty() )
        {
            val intent = Intent(this@FilterFromAppointmentActivity, DiagnosisListActivity::class.java)//DiagnosisListActivity
            finish()
            startActivity(intent)


        } else {
            funOpenWarningPopup(binding.etSSN, "*Please fill mandatory fields")
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

        // step 3
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
        okBtnTxt.setOnClickListener {
            popupWindow.dismiss()
        }

    }
}