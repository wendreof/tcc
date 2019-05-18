package com.example.wlf.ktempconverter.classes.Adapter

import com.example.wlf.ktempconverter.classes.Interface.TemperatureKotlin
import com.example.wlf.ktempconverter.classes.ThermometricScale.ThermometricScaleKotlin

class AdapterKotlin : TemperatureKotlin, ThermometricScaleKotlin() {

    override fun viewTemperature(value: Float, s: Char): Float {
        return when (s) {
            'c' -> ThermometricScaleKotlin().celsius(value)

            'f' -> ThermometricScaleKotlin().fahrenheit(value)

            'k' -> ThermometricScaleKotlin().kelvin(value)

            else -> 0f
        }
    }
}


