package com.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.isamed.R
import com.isamed.databinding.FragmentDocBinding
import com.ui.activities.HomeActivity

class DocFragment : Fragment() {

    lateinit var binding: FragmentDocBinding


    var returnValue = "Insurance Card"

    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
        binding = FragmentDocBinding.inflate(layoutInflater)




        binding.ivHomeIcon.setOnClickListener {
            val intent = Intent(context, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)




        }


        binding.tvShowDropdown.setOnClickListener {
            view?.let { it1 -> my_button_onClick_working(it1) }
        }




        return binding.root
    }

    fun my_button_onClick_working(view: View) {

        val popupView= layoutInflater.inflate(R.layout.layout_popup_bottom_list,null)

        val tv_doc1: TextView = popupView.findViewById(R.id.tv_doc1)
        val tv_doc2: TextView = popupView.findViewById(R.id.tv_doc2)
        val tv_doc3: TextView = popupView.findViewById(R.id.tv_doc3)
        val tv_doc4: TextView = popupView.findViewById(R.id.tv_doc4)
        val tv_doc5: TextView = popupView.findViewById(R.id.tv_doc5)
        val tvDoneBtn: TextView = popupView.findViewById(R.id.tv_doneBtn)
        val tvCancelBtn: TextView = popupView.findViewById(R.id.tv_cancelBtn)



        val wid = LinearLayout.LayoutParams.MATCH_PARENT
        val high = LinearLayout.LayoutParams.WRAP_CONTENT
        val focus= true
        val popupWindow = PopupWindow(popupView, wid, high, focus)

        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0)

        val selectedDoc=binding.tvShowDropdown.text.toString()



        when(selectedDoc)
        {
            tv_doc1.text ->{
                tv_doc1.setBackgroundResource(R.color.ll_bg_color)
            }
            tv_doc2.text ->{
                tv_doc2.setBackgroundResource(R.color.ll_bg_color)
            }
            tv_doc3.text ->{
                tv_doc3.setBackgroundResource(R.color.ll_bg_color)
            }
            tv_doc4.text ->{
                tv_doc4.setBackgroundResource(R.color.ll_bg_color)
            }
            tv_doc5.text ->{
                tv_doc5.setBackgroundResource(R.color.ll_bg_color)
            }


        }


        tv_doc1.setOnClickListener {
            returnValue =  tv_doc1.text.toString()
            tv_doc1.setBackgroundResource(R.color.ll_bg_color)
            tv_doc2.setBackgroundResource(R.color.white)
            tv_doc3.setBackgroundResource(R.color.white)
            tv_doc4.setBackgroundResource(R.color.white)
            tv_doc5.setBackgroundResource(R.color.white)

        }
        tv_doc2.setOnClickListener {
            returnValue =  tv_doc2.text.toString()
            tv_doc1.setBackgroundResource(R.color.white)
            tv_doc2.setBackgroundResource(R.color.ll_bg_color)
            tv_doc3.setBackgroundResource(R.color.white)
            tv_doc4.setBackgroundResource(R.color.white)
            tv_doc5.setBackgroundResource(R.color.white)
        }
        tv_doc3.setOnClickListener {
            returnValue =  tv_doc3.text.toString()
            tv_doc1.setBackgroundResource(R.color.white)
            tv_doc2.setBackgroundResource(R.color.white)
            tv_doc3.setBackgroundResource(R.color.ll_bg_color)
            tv_doc4.setBackgroundResource(R.color.white)
            tv_doc5.setBackgroundResource(R.color.white)
        }
        tv_doc4.setOnClickListener {
            returnValue =  tv_doc4.text.toString()
            tv_doc1.setBackgroundResource(R.color.white)
            tv_doc2.setBackgroundResource(R.color.white)
            tv_doc3.setBackgroundResource(R.color.white)
            tv_doc4.setBackgroundResource(R.color.ll_bg_color)
            tv_doc5.setBackgroundResource(R.color.white)
        }
        tv_doc5.setOnClickListener {
            returnValue =  tv_doc5.text.toString()
            tv_doc1.setBackgroundResource(R.color.white)
            tv_doc2.setBackgroundResource(R.color.white)
            tv_doc3.setBackgroundResource(R.color.white)
            tv_doc4.setBackgroundResource(R.color.white)
            tv_doc5.setBackgroundResource(R.color.ll_bg_color)
        }




        tvDoneBtn.setOnClickListener {

            binding.tvShowDropdown.text = returnValue
//            returnValue=tvDoneBtn.text.toString()
            popupWindow.dismiss()
        }

        tvCancelBtn.setOnClickListener {
            popupWindow.dismiss()
        }

    }
}