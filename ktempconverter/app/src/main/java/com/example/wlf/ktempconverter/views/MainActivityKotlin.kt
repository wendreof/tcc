package com.example.wlf.ktempconverter.views

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import com.example.wlf.ktempconverter.R
import com.example.wlf.ktempconverter.classes.Adapter.AdapterKotlin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityKotlin : AppCompatActivity() {
    private val tempAdapter = AdapterKotlin()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        converterButton.setOnClickListener { convert() }
        clear.setOnClickListener { clearFields() }
        clearFields()
    }

    private fun convert() {
        val temp: String = valorTemp.text.toString()

        if (temp.isNotEmpty() && temp != "0") {
            val temp: Float = valorTemp.text.toString().toFloat()

            when {
                fahrenheitRadio.isChecked -> {
                    converted.text = tempAdapter.viewTemperature(temp, 'f').toString()
                    viewFormula(temp, 'F', tempAdapter.viewTemperature(temp, 'f'))
                }

                KelvinRadio.isChecked -> {
                    converted.text = tempAdapter.viewTemperature(temp, 'k').toString()
                    viewFormula(temp, 'K', tempAdapter.viewTemperature(temp, 'k'))
                }
            }
        } else {
            showMSG(getString(R.string.please_type_a_temp))
            valorTemp.error = getString(R.string.type_a_valid_value)
        }
    }

    private fun viewFormula(w: Float, e: Char, b: Float): String {
        formula.visibility = VISIBLE
        return when (e) {
            'F' -> formula.setText("Fórmula (${w}ºC × 9/5) + 32 = ${b}º$e").toString()

            'K' -> formula.setText("Fórmula ${w}ºC + 273.15 = ${b}º$e").toString()

            else -> "0"
        }
    }

    private fun showMSG(msg: String) = Snackbar.make(linear_layout_main, msg, Snackbar.LENGTH_LONG).show()

    private fun clearFields() {
        formula.visibility = GONE
        formula.text = ""
        valorTemp.setText("")
        converted.text = ""
    }
}

