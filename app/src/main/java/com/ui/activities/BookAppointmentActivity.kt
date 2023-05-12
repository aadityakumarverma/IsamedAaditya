package com.ui.activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.interfaces.ProductViewClick
import com.isamed.R
import com.isamed.databinding.ActivityAppointmentListBinding
import com.isamed.databinding.ActivityBookAppointmentBinding
import java.text.SimpleDateFormat
import java.util.*

class BookAppointmentActivity : AppCompatActivity() , ProductViewClick {
    lateinit var binding: ActivityBookAppointmentBinding
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvDone.setOnClickListener {
            funValidateBookingForm("Booking Done.")
        }
        binding.btnCheckAvailability.setOnClickListener {
            funValidateBookingForm("Checking Availability...")
        }

        binding.tvStartTimeValue.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                binding.tvStartTimeValue.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }
        binding.tvEndTimeValue.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                binding.tvEndTimeValue.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }



        binding.ivBackButton.setOnClickListener {
            finish()
        }

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateStartDate()
            }
        }

        val dateSetListener2 = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateEndDate()
            }
        }
        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        binding.tvStartDateValue!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@BookAppointmentActivity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        })
        binding.tvEndDateValue!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@BookAppointmentActivity,
                    dateSetListener2,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        })
        /////////////////////////

    }

    private fun updateDateStartDate() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        binding.tvStartDateValue!!.text = sdf.format(cal.getTime())
    }
    private fun updateDateEndDate() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        binding.tvEndDateValue!!.text = sdf.format(cal.getTime())
    }
    override fun viewProducts(name: String, type: String, price: Int) {

    }

    private fun funValidateBookingForm(msg:String) {

//        Please fill mandatory fields
        if (binding.etFirstName.text.isNotEmpty() && binding.etLastName.text.isNotEmpty()
            && binding.tvStartDateValue.text.isNotEmpty()  && binding.tvEndDateValue.text.isNotEmpty()
            && binding.tvStartTimeValue.text.isNotEmpty()  && binding.tvEndTimeValue.text.isNotEmpty())
        {
            Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show()


        } else {
            funOpenWarningPopup(binding.etFirstName, "*Please fill mandatory fields")
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