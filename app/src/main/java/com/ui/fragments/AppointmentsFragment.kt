package com.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adapters.AllPatientAppointmentAdapter
import com.adapters.SinglePatientAppointmentsAdapter
import com.interfaces.ProductViewClick
import com.isamed.R
import com.isamed.databinding.FragmentAppointmentsBinding
import com.isamed.databinding.FragmentDocBinding
import com.modalClasses.AllPatientAppointmentModel
import com.modalClasses.SinglePatientAppointmentsModel
import com.ui.activities.HomeActivity

class AppointmentsFragment : Fragment(), ProductViewClick {

    lateinit var binding: FragmentAppointmentsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAppointmentsBinding.inflate(layoutInflater)
        val v =inflater.inflate(R.layout.fragment_appointments, container, false)

        var ivHomeIcon =v.findViewById<ImageView>(R.id.iv_homeIcon)

        ivHomeIcon.setOnClickListener {
            val intent = Intent(v.context,HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        val rv_singlePatientAppointment = v.findViewById<RecyclerView>(R.id.rv_singlePatientAppointment)

        val arrPatientDetails=ArrayList<SinglePatientAppointmentsModel>()
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientAppointmentsModel("06/29/2010","15:22:47"))

        val rvAdapter = SinglePatientAppointmentsAdapter(v.context,arrPatientDetails,this)
        rv_singlePatientAppointment.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.VERTICAL,false)
        rv_singlePatientAppointment.adapter = rvAdapter

        return v
    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }
}