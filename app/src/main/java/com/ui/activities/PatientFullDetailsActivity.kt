package com.ui.activities

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.isamed.R
import com.isamed.databinding.ActivityPatientFullDetailsBinding
import com.ui.fragments.*

private val infoFragment=  InfoFragment()
private  val appointmentsFragment = AppointmentsFragment()
private  val docFragment = DocFragment()
private val labOrderFragment = LabOrderFragment()
private  val testResultsFragment = TestResultsFragment()
private  val prescriptionFragment = PrescriptionFragment()
private val paymentFragment = PaymentFragment()

class PatientFullDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityPatientFullDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientFullDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(infoFragment)
        changeTabBG(binding.llInfoTab)



        binding.llInfoTab.setOnClickListener {
            replaceFragment(infoFragment)
            changeTabBG(binding.llInfoTab)

        }

        binding.llAppointmentTab.setOnClickListener {
            replaceFragment(appointmentsFragment)
            changeTabBG(binding.llAppointmentTab)

        }
        binding.llDocTab.setOnClickListener {
            replaceFragment(docFragment)
            changeTabBG(binding.llDocTab)

        }
        binding.llLabOrderTab.setOnClickListener {
            replaceFragment(labOrderFragment)
            changeTabBG(binding.llLabOrderTab)

        }
        binding.llTestResultTab.setOnClickListener {
            replaceFragment(testResultsFragment)
            changeTabBG(binding.llTestResultTab)

        }
        binding.llPrescriptionTab.setOnClickListener {
            replaceFragment(prescriptionFragment)
            changeTabBG(binding.llPrescriptionTab)

        }
        binding.llPaymentTab.setOnClickListener {
            replaceFragment(paymentFragment)
            changeTabBG(binding.llPaymentTab)

        }



    }

    private fun changeTabBG(llSelectedTab: LinearLayout) {
        binding.llInfoTab.setBackgroundResource(R.drawable.tab_false)
        binding.ivInfoTab.setImageResource(R.drawable.info_icon_gray)
        binding.tvInfoTab.setTextColor(Color.parseColor("#a2a2a2"));

        binding.llAppointmentTab.setBackgroundResource(R.drawable.tab_false)
        binding.ivAppointmentTab.setImageResource(R.drawable.appointment_icon_gray)
        binding.tvAppointmentTab.setTextColor(Color.parseColor("#a2a2a2"));

        binding.llDocTab.setBackgroundResource(R.drawable.tab_false)
        binding.ivDocTab.setImageResource(R.drawable.doc_icon_gray)
        binding.tvDocTab.setTextColor(Color.parseColor("#a2a2a2"));

        binding.llLabOrderTab.setBackgroundResource(R.drawable.tab_false)
        binding.ivLabOrderTab.setImageResource(R.drawable.lab_ord_icon_gray)
        binding.tvLabOrderTab.setTextColor(Color.parseColor("#a2a2a2"));

        binding.llTestResultTab.setBackgroundResource(R.drawable.tab_false)
        binding.ivTestResultTab.setImageResource(R.drawable.test_result_icon_gray)
        binding.tvTestResultTab.setTextColor(Color.parseColor("#a2a2a2"));

        binding.llPrescriptionTab.setBackgroundResource(R.drawable.tab_false)
        binding.ivPrescriptionTab.setImageResource(R.drawable.prescription_icon_gray)
        binding.tvPrescriptionTab.setTextColor(Color.parseColor("#a2a2a2"));

        binding.llPaymentTab.setBackgroundResource(R.drawable.tab_false)
        binding.ivPaymentTab.setImageResource(R.drawable.pay_icon_gray)
        binding.tvPaymentTab.setTextColor(Color.parseColor("#a2a2a2"));


        when(llSelectedTab.id){
            R.id.ll_infoTab -> {
                binding.llInfoTab.setBackgroundResource(R.drawable.tab_true)
                binding.ivInfoTab.setImageResource(R.drawable.info_icon_white)
                binding.tvInfoTab.setTextColor(Color.parseColor("#ffffff"));
            }
            R.id.ll_AppointmentTab -> {
                binding.llAppointmentTab.setBackgroundResource(R.drawable.tab_true)
                binding.ivAppointmentTab.setImageResource(R.drawable.appointment_icon_white)
                binding.tvAppointmentTab.setTextColor(Color.parseColor("#ffffff"));
            }
            R.id.ll_docTab -> {
                binding.llDocTab.setBackgroundResource(R.drawable.tab_true)
                binding.ivDocTab.setImageResource(R.drawable.doc_icon_white)
                binding.tvDocTab.setTextColor(Color.parseColor("#ffffff"));
            }
            R.id.ll_labOrderTab -> {
                binding.llLabOrderTab.setBackgroundResource(R.drawable.tab_true)
                binding.ivLabOrderTab.setImageResource(R.drawable.lab_ord_icon_white)
                binding.tvLabOrderTab.setTextColor(Color.parseColor("#ffffff"));
            }
            R.id.ll_testResultTab -> {
                binding.llTestResultTab.setBackgroundResource(R.drawable.tab_true)
                binding.ivTestResultTab.setImageResource(R.drawable.test_result_icon_white)
                binding.tvTestResultTab.setTextColor(Color.parseColor("#ffffff"));
            }
            R.id.ll_prescriptionTab -> {
                binding.llPrescriptionTab.setBackgroundResource(R.drawable.tab_true)
                binding.ivPrescriptionTab.setImageResource(R.drawable.prescription_icon_white)
                binding.tvPrescriptionTab.setTextColor(Color.parseColor("#ffffff"));
            }
            R.id.ll_paymentTab -> {
                binding.llPaymentTab.setBackgroundResource(R.drawable.tab_true)
                binding.ivPaymentTab.setImageResource(R.drawable.pay_icon_white)
                binding.tvPaymentTab.setTextColor(Color.parseColor("#ffffff"));
            }
        }

    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment!= null)
        {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fl_patientAllDetails,fragment)
            transaction.commit()
        }
    }
    /*private fun replaceFragmentHome(fragment: Fragment){
        if(fragment!= null)
        {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fl_patientAllDetails,fragment).addToBackStack("a2b")
            transaction.commit()
        }
    }*/

}