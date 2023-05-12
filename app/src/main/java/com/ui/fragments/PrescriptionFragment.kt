package com.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.isamed.R
import com.isamed.databinding.FragmentPaymentBinding
import com.isamed.databinding.FragmentPrescriptionBinding
import com.ui.activities.HomeActivity
import com.ui.activities.PrescriptionAddActivity

class PrescriptionFragment : Fragment() {
    lateinit var binding: FragmentPrescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrescriptionBinding.inflate(layoutInflater)
        val v =inflater.inflate(R.layout.fragment_prescription, container, false)

        var ivHomeIcon =v.findViewById<ImageView>(R.id.iv_homeIcon)
        var ivAddIcon =v.findViewById<ImageView>(R.id.iv_addIcon)

        ivHomeIcon.setOnClickListener {
            val intent = Intent(v.context, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
        ivAddIcon.setOnClickListener {
            val intent = Intent(v.context, PrescriptionAddActivity::class.java)
            startActivity(intent)
        }


        return v
    }
}