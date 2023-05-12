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
import com.isamed.databinding.LayoutCptCodeListBinding
import com.isamed.databinding.LayoutDiagnosisListBinding
import com.isamed.databinding.LayoutSinglePatientTestResultBinding
import com.modalClasses.CptCodeListModel
import com.modalClasses.DiagnosisListModel
import com.ui.activities.TestResultDetailsActivity

class CptCodeListAdapter(val context: Context, val arrPatientDetails: ArrayList<CptCodeListModel>, val click: ProductViewClick) : RecyclerView.Adapter<CptCodeListAdapter.ViewHolder>(){
    lateinit var binding: LayoutCptCodeListBinding
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val tvReportNameValue = itemView.findViewById<TextView>(R.id.tv_reportNameValue)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_cpt_code_list, parent, false))
    }

    override fun getItemCount(): Int {
        return arrPatientDetails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        arrPatientDetails[position].apply {
            holder.tvReportNameValue.text= reportName
        }


        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Report Entry", Toast.LENGTH_SHORT).show()
            /*context.startActivity(Intent(context,ProductDetails::class.java))
//            click.viewProducts("Aditya","View",1000)*/
//            context.startActivity(Intent(context, TestResultDetailsActivity::class.java))
        }
    }


}