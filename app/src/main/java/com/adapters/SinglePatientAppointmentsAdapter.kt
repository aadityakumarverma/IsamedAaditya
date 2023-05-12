package com.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.interfaces.ProductViewClick
import com.isamed.R
import com.isamed.databinding.LayoutSinglePatientAppointmentsBinding
import com.modalClasses.SinglePatientAppointmentsModel
import com.ui.activities.AppointmentDetailsActivity

class SinglePatientAppointmentsAdapter(val context: Context, val arrPatientDetails: ArrayList<SinglePatientAppointmentsModel>, val click: ProductViewClick) : RecyclerView.Adapter<SinglePatientAppointmentsAdapter.ViewHolder>(){
    lateinit var binding: LayoutSinglePatientAppointmentsBinding
    /*var onItemClick : ((ProductModel) -> Unit)? = null*/
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val tvAppointmentDate = itemView.findViewById<TextView>(R.id.tv_AppointmentDate)
        val tvAppointmentTime = itemView.findViewById<TextView>(R.id.tv_AppointmentTime)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_single_patient_appointments, parent, false))
    }

    override fun getItemCount(): Int {
        return arrPatientDetails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        arrPatientDetails[position].apply {
            holder.tvAppointmentDate.text= appointmentDate
            holder.tvAppointmentTime.text = appointmentTime
        }


        holder.itemView.setOnClickListener {

            context.startActivity(Intent(context,AppointmentDetailsActivity::class.java))
        }
    }


}