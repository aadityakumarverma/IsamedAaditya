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
import com.isamed.databinding.LayoutSinglePatientTestResultBinding
import com.modalClasses.SinglePatientTestResultModel
import com.ui.activities.PaymentDetailsActivity
import com.ui.activities.PrescriptionAddActivity
import com.ui.activities.TestResultDetailsActivity

class SinglePatientTestResultAdapter(val context: Context, val arrPatientDetails: ArrayList<SinglePatientTestResultModel>, val click: ProductViewClick) : RecyclerView.Adapter<SinglePatientTestResultAdapter.ViewHolder>(){
    lateinit var binding: LayoutSinglePatientTestResultBinding
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val tvTestResultDateValue = itemView.findViewById<TextView>(R.id.tv_testResultDateValue)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_single_patient_test_result, parent, false))
    }

    override fun getItemCount(): Int {
        return arrPatientDetails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        arrPatientDetails[position].apply {
            holder.tvTestResultDateValue.text= testResultDate
        }


        holder.itemView.setOnClickListener {
            /*context.startActivity(Intent(context,ProductDetails::class.java))
//            click.viewProducts("Aditya","View",1000)*/
            context.startActivity(Intent(context, TestResultDetailsActivity::class.java))
        }
    }


}