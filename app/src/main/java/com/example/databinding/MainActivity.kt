package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Lee","012345679")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName

        binding.buttonDone.setOnClickListener {
            showName()
        }


    }

    private fun showName(){
        binding.apply {
            //combine multiple code in a single line
            myName?.name=editTextName.text.toString()
            myName?.contact=editTextContact.text.toString()
            this.invalidateAll()
            //invalidateAll means the one showed on the screen is no longer valid
        }

    }
}
