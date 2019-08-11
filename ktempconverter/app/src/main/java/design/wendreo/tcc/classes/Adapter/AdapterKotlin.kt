package design.wendreo.tcc.classes.Adapter

import design.wendreo.tcc.classes.Interface.TemperatureKotlin
import design.wendreo.tcc.classes.ThermometricScale.ThermometricScaleKotlin

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


