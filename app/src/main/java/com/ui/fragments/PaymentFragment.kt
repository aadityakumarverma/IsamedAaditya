package com.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adapters.SinglePatientPaymentAdapter
import com.interfaces.ProductViewClick
import com.isamed.R
import com.isamed.databinding.FragmentPaymentBinding
import com.modalClasses.SinglePatientPaymentModel
import com.ui.activities.HomeActivity

class PaymentFragment : Fragment() , ProductViewClick {
    lateinit var binding: FragmentPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentBinding.inflate(layoutInflater)
        val v =inflater.inflate(R.layout.fragment_payment, container, false)
        var ivHomeIcon =v.findViewById<ImageView>(R.id.iv_homeIcon)

        ivHomeIcon.setOnClickListener {
            val intent = Intent(v.context, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        val rv_singlePatientPayment = v.findViewById<RecyclerView>(R.id.rv_singlePatientPayment)

        val arrPatientDetails=ArrayList<SinglePatientPaymentModel>()
        arrPatientDetails.add(SinglePatientPaymentModel("03/08/2023","13:31:33"))
        arrPatientDetails.add(SinglePatientPaymentModel("03/08/2023","13:31:33"))
        arrPatientDetails.add(SinglePatientPaymentModel("03/08/2023","13:31:33"))
        arrPatientDetails.add(SinglePatientPaymentModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientPaymentModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientPaymentModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientPaymentModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientPaymentModel("03/08/2023","13:31:33"))
        arrPatientDetails.add(SinglePatientPaymentModel("03/08/2023","13:31:33"))
        arrPatientDetails.add(SinglePatientPaymentModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientPaymentModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientPaymentModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientPaymentModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientPaymentModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientPaymentModel("06/29/2010","15:22:47"))
        arrPatientDetails.add(SinglePatientPaymentModel("06/29/2010","15:22:47"))

        val rvAdapter = SinglePatientPaymentAdapter(v.context,arrPatientDetails,this)
        rv_singlePatientPayment.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.VERTICAL,false)
        rv_singlePatientPayment.adapter = rvAdapter



        return v
    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }

}