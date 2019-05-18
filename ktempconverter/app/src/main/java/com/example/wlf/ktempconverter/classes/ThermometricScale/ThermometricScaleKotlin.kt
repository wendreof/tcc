package com.example.wlf.ktempconverter.classes.ThermometricScale

open class ThermometricScaleKotlin {
    fun celsius(value: Float): Float = (value - 32) * 5 / 9

    fun fahrenheit(value: Float): Float = (value * 9 / 5) + 32

    fun kelvin(value: Float): Float = value + 273.15f
}

