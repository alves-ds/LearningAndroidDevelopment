package com.alvesds.minhacomposicao.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alvesds.minhacomposicao.R;

public class CalculoImcActivity extends AppCompatActivity {

    EditText entrada_estatura, entrada_massa;
    Button calcular;
    float IMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Instancias();
        CalcularImc();

    }

    private void Instancias() {
        entrada_estatura = findViewById(R.id.entrada_estatura);
        entrada_massa = findViewById(R.id.entrada_massa_corporal);
        calcular = findViewById(R.id.botao_calcular_imc);
    }

    private void CalcularImc() {
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String estatura2 = entrada_estatura.getText().toString();
                String massa2 = entrada_massa.getText().toString();
                if ((!IsStringEmpty(estatura2)) && (!IsStringEmpty(massa2))) {
                    float estatura = Float.parseFloat(estatura2);
                    float massa = Float.parseFloat(massa2);
                    float estatura_quadrada = estatura * estatura;
                    IMC = massa / estatura_quadrada;

                    if ((IMC > 24.9) && (IMC < 29.9)) {
                        Intent sobrepeso = new Intent(CalculoImcActivity.this, SobrepesoActivity.class);
                        Toast.makeText(CalculoImcActivity.this, "IMC calculado com sucesso!", Toast.LENGTH_SHORT).show();
                        sobrepeso.putExtra("imc_sobrepeso", IMC);
                        startActivity(sobrepeso);
                    }
                    if (IMC > 29.9) {
                        Intent obeso = new Intent(CalculoImcActivity.this, ObesoActivity.class);
                        Toast.makeText(CalculoImcActivity.this, "IMC calculado com sucesso!", Toast.LENGTH_SHORT).show();
                        obeso.putExtra("imc_obeso", IMC);
                        startActivity(obeso);
                    }
                    if ((IMC < 24.9) && (IMC > 18.5)) {
                        Intent eutrofico = new Intent(CalculoImcActivity.this, EutroficoActivity.class);
                        Toast.makeText(CalculoImcActivity.this, "IMC calculado com sucesso!", Toast.LENGTH_SHORT).show();
                        eutrofico.putExtra("imc_eutrofico", IMC);
                        startActivity(eutrofico);
                    }
                    if (IMC < 18.5) {
                        Intent baixopeso = new Intent(CalculoImcActivity.this, BaixoPesoActivity.class);
                        Toast.makeText(CalculoImcActivity.this, "IMC calculado com sucesso!", Toast.LENGTH_SHORT).show();
                        baixopeso.putExtra("imc_baixopeso", IMC);
                        startActivity(baixopeso);
                    }
                } else {
                    Toast.makeText(CalculoImcActivity.this, "Não deixe nenhum campo em branco!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean IsStringEmpty(String inputstring) {

        if (inputstring.isEmpty() || (inputstring == null)) {

            return true;
        } else {
            return false;
        }
    }

}