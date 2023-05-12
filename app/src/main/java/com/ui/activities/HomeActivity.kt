package com.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.isamed.R
import com.isamed.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var popupMenu : PopupMenu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvSchedule.setOnClickListener {
//            Toast.makeText(this, ""+binding.tvSchedule.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this@HomeActivity,AppointmentListActivity::class.java)
            startActivity(intent)
        }
        binding.tvSearchPatient.setOnClickListener {
//            Toast.makeText(this, ""+binding.tvSearchPatient.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this@HomeActivity,SearchPatientActivity::class.java)
            startActivity(intent)
        }


        binding.tvPrescription.setOnClickListener {
//            Toast.makeText(this, ""+binding.tvPrescription.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this@HomeActivity,FilterActivity::class.java)
            startActivity(intent)
        }
        binding.tvTestResults.setOnClickListener {
//            Toast.makeText(this, ""+binding.tvTestResults.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this@HomeActivity,FilterActivity::class.java)
            startActivity(intent)
        }
        binding.tvLabOrders.setOnClickListener {
//            Toast.makeText(this, ""+binding.tvLabOrders.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this@HomeActivity,FilterActivity::class.java)
            startActivity(intent)
        }
        binding.tvSonograms.setOnClickListener {
//            Toast.makeText(this, ""+binding.tvSonograms.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this@HomeActivity,FilterActivity::class.java)
            intent.putExtra("page","sonogramToFilter")
            startActivity(intent)
        }


        binding.ivDotLogOut.setOnClickListener {
            popupMenu = PopupMenu(this@HomeActivity,binding.ivDotLogOut)
            var menuView=popupMenu.menuInflater.inflate(R.menu.nav_menu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { menuItem ->
                onOptionsItemSelected(menuItem)
                true
            }



            popupMenu.show()
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.nav_contact_us -> {
                contactUs()
                true
            }
            R.id.nav_logout -> {
                logOut()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun contactUs() {
        val intent=Intent(this@HomeActivity,ContactUsActivity::class.java)
        startActivity(intent)
    }

    fun logOut() {
        val intent=Intent(this@HomeActivity,LoginActivity::class.java)
        finishAffinity()
        startActivity(intent)
    }
}