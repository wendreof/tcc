package design.wendreo.tcc.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import design.wendreo.tcc.R
import design.wendreo.tcc.views.uncommenteds.MainActivityJava
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
