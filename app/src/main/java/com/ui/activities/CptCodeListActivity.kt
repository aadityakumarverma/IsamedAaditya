package com.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.adapters.CptCodeListAdapter
import com.interfaces.ProductViewClick
import com.isamed.databinding.ActivityCptCodeListBinding
import com.modalClasses.CptCodeListModel

class CptCodeListActivity : AppCompatActivity(), ProductViewClick {
    lateinit var binding: ActivityCptCodeListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCptCodeListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }
        binding.tvNext.setOnClickListener {
            val intent = Intent(this@CptCodeListActivity,CptDetailsActivity::class.java)
            startActivity(intent)
        }

        val arrPatientDetails=ArrayList<CptCodeListModel>()
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))
        arrPatientDetails.add(CptCodeListModel("36415 COLLECTION VENOUS BLOOD VENIPUNCTURE"))

        val rvAdapter = CptCodeListAdapter(this,arrPatientDetails,this)
        binding.rvCptCodeList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvCptCodeList.adapter = rvAdapter

    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }
}