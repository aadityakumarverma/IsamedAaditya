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
import com.isamed.databinding.LayoutSinglePatientPaymentBinding
import com.modalClasses.SinglePatientPaymentModel
import com.ui.activities.PaymentDetailsActivity

class SinglePatientPaymentAdapter(val context: Context, val arrPatientDetails: ArrayList<SinglePatientPaymentModel>, val click: ProductViewClick) : RecyclerView.Adapter<SinglePatientPaymentAdapter.ViewHolder>(){
    lateinit var binding: LayoutSinglePatientPaymentBinding
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val tvPaymentDateValue = itemView.findViewById<TextView>(R.id.tv_paymentDateValue)
        val tvPaymentTimeValue = itemView.findViewById<TextView>(R.id.tv_paymentTimeValue)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_single_patient_payment, parent, false))
    }

    override fun getItemCount(): Int {
        return arrPatientDetails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        arrPatientDetails[position].apply {
            holder.tvPaymentDateValue.text= paymentDate
            holder.tvPaymentTimeValue.text = paymentTime
        }


        holder.itemView.setOnClickListener {
            /*context.startActivity(Intent(context,ProductDetails::class.java))
//            click.viewProducts("Aditya","View",1000)*/
            context.startActivity(Intent(context,PaymentDetailsActivity::class.java))
        }
    }


}