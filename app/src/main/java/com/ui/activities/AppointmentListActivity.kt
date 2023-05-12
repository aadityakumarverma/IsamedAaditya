package com.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adapters.AllPatientAppointmentAdapter
import com.interfaces.ProductViewClick
import com.isamed.databinding.ActivityAppointmentListBinding
import com.modalClasses.AllPatientAppointmentModel

class AppointmentListActivity : AppCompatActivity() ,ProductViewClick{
    lateinit var binding: ActivityAppointmentListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAppointmentListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvBookAppointment.setOnClickListener {
            val intent = Intent(this@AppointmentListActivity, BookAppointmentActivity::class.java)
            startActivity(intent)
        }


        binding.ivBackButton.setOnClickListener {
            finish()
        }
        binding.ivThreeBar.setOnClickListener {
            val intent = Intent(this@AppointmentListActivity, FilterFromAppointmentActivity::class.java)
            startActivity(intent)

        }

        val arrPatientDetails=ArrayList<AllPatientAppointmentModel>()
        arrPatientDetails.add(AllPatientAppointmentModel("WINTIRCH ELIZABETH","09:00 AM - 09:30 AM","6468729504","NEW PATIENT"))
        arrPatientDetails.add(AllPatientAppointmentModel("WINTIRCH ELIZABETH","09:00 AM - 09:30 AM","6468729504","NEW PATIENT"))
        arrPatientDetails.add(AllPatientAppointmentModel("WINTIRCH ELIZABETH","09:00 AM - 09:30 AM","6468729504","NEW PATIENT"))
        arrPatientDetails.add(AllPatientAppointmentModel("WINTIRCH ELIZABETH","09:00 AM - 09:30 AM","6468729504","NEW PATIENT"))
        arrPatientDetails.add(AllPatientAppointmentModel("WINTIRCH ELIZABETH","09:00 AM - 09:30 AM","6468729504","NEW PATIENT"))
        arrPatientDetails.add(AllPatientAppointmentModel("WINTIRCH ELIZABETH","09:00 AM - 09:30 AM","6468729504","NEW PATIENT"))

        val rvAdapter = AllPatientAppointmentAdapter(this,arrPatientDetails,this)
        binding.rvAppointments.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvAppointments.adapter = rvAdapter


    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }
}