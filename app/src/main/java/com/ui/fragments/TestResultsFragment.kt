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
import com.adapters.SinglePatientPaymentAdapter
import com.adapters.SinglePatientTestResultAdapter
import com.interfaces.ProductViewClick
import com.isamed.R
import com.isamed.databinding.FragmentDocBinding
import com.isamed.databinding.FragmentTestResultsBinding
import com.modalClasses.SinglePatientTestResultModel
import com.ui.activities.HomeActivity

class TestResultsFragment : Fragment(), ProductViewClick {

    lateinit var binding: FragmentTestResultsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestResultsBinding.inflate(layoutInflater)
        val v =inflater.inflate(R.layout.fragment_test_results, container, false)
        var ivHomeIcon =v.findViewById<ImageView>(R.id.iv_homeIcon)

        ivHomeIcon.setOnClickListener {
            val intent = Intent(v.context, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        val rv_singlePatientTestResult = v.findViewById<RecyclerView>(R.id.rv_singlePatientTestResult)

        val arrPatientDetails=ArrayList<SinglePatientTestResultModel>()
        arrPatientDetails.add(SinglePatientTestResultModel("03/08/2023"))
        arrPatientDetails.add(SinglePatientTestResultModel("03/08/2023"))
        arrPatientDetails.add(SinglePatientTestResultModel("03/08/2023"))
        arrPatientDetails.add(SinglePatientTestResultModel("03/08/2023"))
        arrPatientDetails.add(SinglePatientTestResultModel("03/08/2023"))
        arrPatientDetails.add(SinglePatientTestResultModel("03/08/2023"))
        arrPatientDetails.add(SinglePatientTestResultModel("03/08/2023"))
        arrPatientDetails.add(SinglePatientTestResultModel("03/08/2023"))
        arrPatientDetails.add(SinglePatientTestResultModel("03/08/2023"))
        arrPatientDetails.add(SinglePatientTestResultModel("03/08/2023"))
        arrPatientDetails.add(SinglePatientTestResultModel("03/08/2023"))
        arrPatientDetails.add(SinglePatientTestResultModel("03/08/2023"))

        val rvAdapter = SinglePatientTestResultAdapter(v.context,arrPatientDetails,this)
        rv_singlePatientTestResult.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.VERTICAL,false)
        rv_singlePatientTestResult.adapter = rvAdapter


        return v
    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }
}