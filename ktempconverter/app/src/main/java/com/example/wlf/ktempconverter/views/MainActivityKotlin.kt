package com.example.wlf.ktempconverter.views

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.WindowManager
import com.example.wlf.ktempconverter.R
import com.example.wlf.ktempconverter.classes.Adapter.AdapterKotlin

/* A importacao abaixo dispensa a declaracao de findViewById's para cada um dos widgets
 declarados no arquivo XML de interface */
import kotlinx.android.synthetic.main.activity_main_kotlin.*

class MainActivityKotlin : AppCompatActivity() {
    private val tempAdapter = AdapterKotlin()

    /* Declara-se na mesma linha que se trata de uma funcao de sobreescrita */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kotlin)

        /* Pontos e virgulas ao final sao opcionais e desencorajados pela propria IDE */
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        /* Acesso direto a operacao de click e chamada as funcoes de forma mais simples */
        converterButton.setOnClickListener { convert() }
        clear.setOnClickListener { clearFields() }
    }

    private fun convert() {

        /* Pode-se capturar o atributo texto diretamente sem o metodo get */
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

            /* Pode-se atribuir um texto sem utilizar o set */
            valorTemp.error = getString(R.string.type_a_valid_value)
        }
    }

    private fun viewFormula(w: Float, e: Char, b: Float): String {

        /* Acesso direto a propriedade visibiliy, sem uso de set */
        formula.visibility = VISIBLE

        /* A estrutura When ja ira retornar o devido valor */
        return when (e) {

            'F' -> formula.setText("Formula (${w}ºC × 9/5) + 32 = ${b}º$e").toString()

            /* A interpolacao de variaveis e textos com ${} dispensa a utilizacao de String.format*/
            'K' -> formula.setText("Formula ${w}ºC + 273.15 = ${b}º$e").toString()

            else -> "0"
        }
    }

    /* Funcoes com logica e retorno simples, podem ser declarados na mesma linha */
    private fun showMSG(msg: String) = Snackbar.make(scrollview, msg, Snackbar.LENGTH_LONG).show()

    private fun clearFields() {
        formula.visibility = GONE
        formula.text = ""
        valorTemp.setText("")
        converted.text = ""
    }
}

