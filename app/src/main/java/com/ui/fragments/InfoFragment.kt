package com.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.isamed.R
import com.isamed.databinding.FragmentAppointmentsBinding
import com.isamed.databinding.FragmentInfoBinding
import com.ui.activities.HomeActivity

class InfoFragment : Fragment() {

    lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(layoutInflater)
        val v =inflater.inflate(R.layout.fragment_info, container, false)
        var ivHomeIcon =v.findViewById<ImageView>(R.id.iv_homeIcon)

        ivHomeIcon.setOnClickListener {
            val intent = Intent(v.context, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }



        return v
    }
}