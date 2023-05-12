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
import com.isamed.databinding.LayoutAllPatientAppointmentBinding
import com.modalClasses.AllPatientAppointmentModel
import com.ui.activities.PatientFullDetailsActivity

class AllPatientAppointmentAdapter(val context: Context, val arrPatientDetails: ArrayList<AllPatientAppointmentModel>, val click: ProductViewClick) : RecyclerView.Adapter<AllPatientAppointmentAdapter.ViewHolder>(){
lateinit var binding: LayoutAllPatientAppointmentBinding
    /*var onItemClick : ((ProductModel) -> Unit)? = null*/
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val tvPatientName = itemView.findViewById<TextView>(R.id.tvPatientName)
        val tvScheduleTime = itemView.findViewById<TextView>(R.id.tvScheduleTime)
        val tvPatientPhone = itemView.findViewById<TextView>(R.id.tvPatientPhone)
        val tvPatientReason = itemView.findViewById<TextView>(R.id.tvPatientReason)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_all_patient_appointment, parent, false))
    }

    override fun getItemCount(): Int {
        return arrPatientDetails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        arrPatientDetails[position].apply {
            holder.tvPatientName.text= PatientName
            holder.tvScheduleTime.text = ScheduleTime
            holder.tvPatientPhone.text= PatientPhone
            holder.tvPatientReason.text = PatientReason
        }


       holder.tvPatientPhone.setOnClickListener {
            Toast.makeText(context, "Msg or Call to "+holder.tvPatientPhone.text.toString(), Toast.LENGTH_SHORT).show()
        }

    }


}