package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.fragments.fragment.fragment1
import com.example.fragments.fragment.fragment2

class MainActivity : AppCompatActivity() , comm1 {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn1 = findViewById<Button>(R.id.button)
        val btn2 = findViewById<Button>(R.id.button2)

        val frg1 = fragment1()
        val frg2 = fragment2()

        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fragment_container, frg1)
            commit()

        }


        btn1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragment_container, frg1)
                addToBackStack(null)
                commit()
            }
        }

        btn2.setOnClickListener {
            val et1 = findViewById<EditText>(R.id.editTextText)
            frg2.arguments = passTheData(et1.text.toString())
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, frg2)
                addToBackStack(null)
                commit()

            }
        }

    }

    override fun passTheData(PassingText: String): Bundle {
        val bundle = Bundle(0)
        bundle.putString("txtAtoB" , PassingText)
        return bundle
    }
}