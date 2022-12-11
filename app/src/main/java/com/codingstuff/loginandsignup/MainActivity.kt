package com.codingstuff.loginandsignup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.codingstuff.loginandsignup.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        fun replaceFragment (fragment: Fragment ){
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout,fragment)
            fragmentTransaction.commit()
        }

        replaceFragment(anasayfa())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

             R.id.Anasayfa -> replaceFragment(anasayfa())
                R.id.bilgi -> replaceFragment(bilgi())
                R.id.kisisel_veri -> replaceFragment(kisisel_veri())
                R.id.egzersiz -> replaceFragment(egzersiz())
            }

            true
        }

    }
}