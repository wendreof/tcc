package com.example.wlf.ktempconverter.views;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.wlf.ktempconverter.R;
import com.example.wlf.ktempconverter.classes.Adapter.AdapterJava;

import static android.view.View.GONE;

public class MainActivityJava extends AppCompatActivity {
    private AdapterJava tempAdapter = new AdapterJava();

    private EditText valorTemp;
    private TextView formula;
    private TextView converted;
    private Button clear;
    private Button converterButton;
    private RadioButton fahrenheitRadio;
    private RadioButton KelvinRadio;
    private ScrollView linear_layout_main_JAVA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);

        valorTemp = findViewById(R.id.valorTemp);
        formula = findViewById(R.id.formula);
        converted = findViewById(R.id.converted);
        clear = findViewById(R.id.clear);
        converterButton = findViewById(R.id.converterButton);
        KelvinRadio = findViewById(R.id.KelvinRadio);
        fahrenheitRadio = findViewById(R.id.fahrenheitRadio);

        clearFields();
    }

    private void convert() {

        final String temp = valorTemp.getText().toString();

        if (!temp.isEmpty() && !temp.equals("0")) {

            final Float tempF = Float.parseFloat(valorTemp.getText().toString());

            if (fahrenheitRadio.isChecked()) {
                converted.setText(tempAdapter.viewTemperature(tempF, 'f').toString());
                viewFormula(tempF, 'F', tempAdapter.viewTemperature(tempF, 'f'));

            } else if (KelvinRadio.isChecked()) {
                converted.setText(tempAdapter.viewTemperature(tempF, 'k').toString());
                viewFormula(tempF, 'K', tempAdapter.viewTemperature(tempF, 'k'));
            } else {
                showMSG(getString(R.string.please_type_a_temp));
                valorTemp.setError(getString(R.string.type_a_valid_value));
            }
        }
    }

    private void viewFormula(Float w, Character e, Float b) {
        formula.setVisibility(View.VISIBLE);

        if (e == 'F') {
            formula.setText(String.format("Fórmula (%sºC× 9/5) + 32 =%sº%s", w, b, e));
        } else if (e == 'k') {
            formula.setText(String.format("Fórmula %sºC + 273.15 =%sº%s", w, b, e));
        } else {
            formula.setText("0");
        }
    }

    private void showMSG(String msg) {
        Snackbar.make(linear_layout_main_JAVA, msg, Snackbar.LENGTH_LONG).show();
    }

    private void clearFields() {
        formula.setVisibility(GONE);
        formula.setText("");
        valorTemp.setText("");
        converted.setText("");
    }
}
