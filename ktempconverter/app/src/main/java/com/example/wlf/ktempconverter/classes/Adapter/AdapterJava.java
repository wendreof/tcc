package com.example.wlf.ktempconverter.classes.Adapter;

import com.example.wlf.ktempconverter.classes.Interface.TemperatureJava;
import com.example.wlf.ktempconverter.classes.ThermometricScale.ThermometricScaleJava;

public class AdapterJava extends ThermometricScaleJava implements TemperatureJava {

    @Override
    public Float viewTemperature(Float value, Character s) {
        Float r;
        switch (s) {
            case 'c':
                r = celsius(value);
                break;
            case 'f':
                r = fahrenheit(value);
                break;
            case 'k':
                r = kelvin(value);
                break;
            default:
                r = 0f;
        }
        return r;
    }
}
