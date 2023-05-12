package com.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.adapters.CptDetailsFormAdapter
import com.interfaces.ProductViewClick
import com.isamed.databinding.ActivityCptDetailsBinding
import com.modalClasses.CptDetailsFormModel

class CptDetailsActivity : AppCompatActivity(), ProductViewClick {
    lateinit var binding: ActivityCptDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCptDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }
        binding.tvSave.setOnClickListener {
            Toast.makeText(this, ""+"Saving...", Toast.LENGTH_SHORT).show()
        }

        val arrPatientDetails=ArrayList<CptDetailsFormModel>()
        arrPatientDetails.add(CptDetailsFormModel("51784","ELECTROMYOGRAPHY STUDIES (EMG) OF ANAL OR URETHRAL SPHINCTER,","500","R87.610"))
        arrPatientDetails.add(CptDetailsFormModel("51784","ELECTROMYOGRAPHY STUDIES (EMG) OF ANAL OR URETHRAL SPHINCTER,","500","R87.610"))
        arrPatientDetails.add(CptDetailsFormModel("51784","ELECTROMYOGRAPHY STUDIES (EMG) OF ANAL OR URETHRAL SPHINCTER,","500","R87.610"))

        val rvAdapter = CptDetailsFormAdapter(this,arrPatientDetails,this)
        binding.rvCptCodeList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvCptCodeList.adapter = rvAdapter

    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }
}