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
import com.isamed.databinding.LayoutSinglePatientLabOrderBinding
import com.modalClasses.SinglePatientLabOrderModel
import com.ui.activities.LabOrderDetailsActivity

class SinglePatientLabOrderAdapter(val context: Context, val arrPatientDetails: ArrayList<SinglePatientLabOrderModel>, val click: ProductViewClick) : RecyclerView.Adapter<SinglePatientLabOrderAdapter.ViewHolder>(){
    lateinit var binding: LayoutSinglePatientLabOrderBinding
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val tvLabOrderDateValue = itemView.findViewById<TextView>(R.id.tv_labOrderDateValue)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_single_patient_lab_order, parent, false))
    }

    override fun getItemCount(): Int {
        return arrPatientDetails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        arrPatientDetails[position].apply {
            holder.tvLabOrderDateValue.text= labOrderDate
        }


        holder.itemView.setOnClickListener {
            /*context.startActivity(Intent(context,ProductDetails::class.java))
//            click.viewProducts("Aditya","View",1000)*/
            context.startActivity(Intent(context, LabOrderDetailsActivity::class.java))
        }
    }


}