package design.wendreo.tcc.classes.Adapter;

import design.wendreo.tcc.classes.Interface.TemperatureJava;
import design.wendreo.tcc.classes.ThermometricScale.ThermometricScaleJava;

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
