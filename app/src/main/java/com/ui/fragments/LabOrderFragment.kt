package com.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adapters.SinglePatientLabOrderAdapter
import com.interfaces.ProductViewClick
import com.isamed.R
import com.isamed.databinding.FragmentLabOrderBinding
import com.modalClasses.SinglePatientLabOrderModel
import com.ui.activities.HomeActivity


class LabOrderFragment : Fragment(), ProductViewClick {

    lateinit var binding: FragmentLabOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLabOrderBinding.inflate(layoutInflater)
        val v =inflater.inflate(R.layout.fragment_lab_order, container, false)
        var ivHomeIcon =v.findViewById<ImageView>(R.id.iv_homeIcon)

        ivHomeIcon.setOnClickListener {
            val intent = Intent(v.context, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        val rv_singlePatientLabOrder = v.findViewById<RecyclerView>(R.id.rv_singlePatientLabOrder)

        val arrPatientDetails=ArrayList<SinglePatientLabOrderModel>()
        arrPatientDetails.add(SinglePatientLabOrderModel("08/22/2013"))
        arrPatientDetails.add(SinglePatientLabOrderModel("08/22/2013"))
        arrPatientDetails.add(SinglePatientLabOrderModel("08/22/2013"))
        arrPatientDetails.add(SinglePatientLabOrderModel("08/22/2013"))
        arrPatientDetails.add(SinglePatientLabOrderModel("08/22/2013"))
        arrPatientDetails.add(SinglePatientLabOrderModel("08/22/2013"))
        arrPatientDetails.add(SinglePatientLabOrderModel("08/22/2013"))
        arrPatientDetails.add(SinglePatientLabOrderModel("08/22/2013"))
        arrPatientDetails.add(SinglePatientLabOrderModel("08/22/2013"))
        arrPatientDetails.add(SinglePatientLabOrderModel("08/22/2013"))
        arrPatientDetails.add(SinglePatientLabOrderModel("08/22/2013"))
        arrPatientDetails.add(SinglePatientLabOrderModel("08/22/2013"))

        val rvAdapter = SinglePatientLabOrderAdapter(v.context,arrPatientDetails,this)
        rv_singlePatientLabOrder.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.VERTICAL,false)
        rv_singlePatientLabOrder.adapter = rvAdapter

        return v
    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }
}