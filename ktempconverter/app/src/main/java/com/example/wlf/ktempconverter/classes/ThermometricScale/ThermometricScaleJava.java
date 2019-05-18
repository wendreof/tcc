package com.example.wlf.ktempconverter.classes.ThermometricScale;

public class ThermometricScaleJava {

    protected Float celsius(Float value) {
        return (value - 32) * 5 / 9;
    }

    protected Float fahrenheit(Float value) {
        return (value * 9 / 5) + 32;
    }

    protected Float kelvin(Float value) {
        return value + 273.15f;
    }
}
