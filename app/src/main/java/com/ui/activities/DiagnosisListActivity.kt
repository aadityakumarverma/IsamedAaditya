package com.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adapters.AllPatientAppointmentAdapter
import com.adapters.DiagnosisListAdapter
import com.interfaces.ProductViewClick
import com.isamed.R
import com.isamed.databinding.ActivityDiagnosisListBinding
import com.isamed.databinding.ActivityFilterBinding
import com.modalClasses.AllPatientAppointmentModel
import com.modalClasses.DiagnosisListModel

class DiagnosisListActivity : AppCompatActivity(), ProductViewClick {
    lateinit var binding: ActivityDiagnosisListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDiagnosisListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }
        binding.tvNext.setOnClickListener {
            val intent = Intent(this@DiagnosisListActivity,CptCodeListActivity::class.java)
            startActivity(intent)
        }

        val arrPatientDetails=ArrayList<DiagnosisListModel>()
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))
        arrPatientDetails.add(DiagnosisListModel("N93.9 ABNORMAL UTERINE AND VAGINAL BLEEDING, UNSPECIFIED"))

        val rvAdapter = DiagnosisListAdapter(this,arrPatientDetails,this)
        binding.rvDiagnosisList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvDiagnosisList.adapter = rvAdapter

    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }
}