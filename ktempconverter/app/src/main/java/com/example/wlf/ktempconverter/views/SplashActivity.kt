package com.example.wlf.ktempconverter.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.wlf.ktempconverter.R
import com.example.wlf.ktempconverter.views.uncommenteds.MainActivityJava
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        btnAndroid.setOnClickListener{java()}
        btnKotlin.setOnClickListener{kotlin()}
    }

    private fun java(){
        val intent = Intent(this, MainActivityJava::class.java)
        startActivity(intent)
    }

    private fun kotlin(){
        val intent = Intent(this, MainActivityKotlin::class.java)
        startActivity(intent)
    }
}
