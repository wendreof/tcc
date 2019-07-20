package com.example.wlf.ktempconverter.views;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/* Necessaria a importação dos widgets */
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

    /* Necessaria a criacao de atributos de mesmo tipo dos widgets declarados no arquivo XML de
     interface para utilizar-se na funcao findViewById */
    private EditText valorTemp;
    private TextView formula;
    private TextView converted;
    private Button clear;
    private Button converterButton;
    private RadioButton fahrenheitRadio;
    private RadioButton KelvinRadio;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);

        /* Pontos e virgulas obrigatorios ao final */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Necessaria a realizacao da captura de cada um dos widgets de interface declarados
         no arquivo XML de interface */
        valorTemp = findViewById(R.id.valorTemp);
        formula = findViewById(R.id.formula);
        converted = findViewById(R.id.converted);
        clear = findViewById(R.id.clear);
        converterButton = findViewById(R.id.converterButton);
        KelvinRadio = findViewById(R.id.KelvinRadio);
        fahrenheitRadio = findViewById(R.id.fahrenheitRadio);
    }

    /* Obrigatorio o recebimento de um parametro do tipo View para ser utilizado
     no atributo onClick pelos widgets de interface */
    public void convert(View v) {

        final String temp = valorTemp.getText().toString();

        if (!temp.isEmpty() && !temp.equals("0")) {

            /* Necessaria a criacao de variavel auxiliar para atribuicao de valor */
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

            /* Necessaria a utilizacao de String.format para facilitar interpolacao de variaveis
            e textos */
            formula.setText(String.format("Formula (%sºC× 9/5) + 32 = %sº%s", w, b, e));
        } else if (e == 'K') {
            formula.setText(String.format("Formula %sºC + 273.15 = %sº%s", w, b, e));
        } else {
            formula.setText("0");
        }
    }

    private void showMSG(String msg) {
        Snackbar.make(scrollView, msg, Snackbar.LENGTH_LONG).show();
    }

    public void clearFields(View v) {
        formula.setVisibility(GONE);
        formula.setText("");
        valorTemp.setText("");
        converted.setText("");
    }
}
