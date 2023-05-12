package com.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.interfaces.ProductViewClick
import com.isamed.R
import com.isamed.databinding.LayoutCptCodeListBinding
import com.isamed.databinding.LayoutCptDetailsFormBinding
import com.modalClasses.CptCodeListModel
import com.modalClasses.CptDetailsFormModel

class CptDetailsFormAdapter(val context: Context, val arrPatientDetails: ArrayList<CptDetailsFormModel>, val click: ProductViewClick) : RecyclerView.Adapter<CptDetailsFormAdapter.ViewHolder>(){
    lateinit var binding: LayoutCptDetailsFormBinding
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val tvCptCodeValue = itemView.findViewById<TextView>(R.id.tv_cptCodeValue)
        val tvDescriptionValue = itemView.findViewById<TextView>(R.id.tv_descriptionValue)
        val tvFeesValue = itemView.findViewById<TextView>(R.id.tv_feesValue)
        val tvIcd1Value = itemView.findViewById<TextView>(R.id.tv_icd1Value)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_cpt_details_form, parent, false))
    }

    override fun getItemCount(): Int {
        return arrPatientDetails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        arrPatientDetails[position].apply {
            holder.tvCptCodeValue.text= cptCode
            holder.tvDescriptionValue.text= description
            holder.tvFeesValue.text= fees
            holder.tvIcd1Value.text= icd1
        }


        /*holder.itemView.setOnClickListener {
            Toast.makeText(context, "Report Entry", Toast.LENGTH_SHORT).show()
            *//*context.startActivity(Intent(context,ProductDetails::class.java))
//            click.viewProducts("Aditya","View",1000)*//*
//            context.startActivity(Intent(context, TestResultDetailsActivity::class.java))
        }*/
    }


}