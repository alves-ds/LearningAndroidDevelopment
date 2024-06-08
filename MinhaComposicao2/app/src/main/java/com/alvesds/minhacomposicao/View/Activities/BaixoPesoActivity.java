package com.alvesds.minhacomposicao.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alvesds.minhacomposicao.R;

public class BaixoPesoActivity extends AppCompatActivity {

    TextView imc;
    float IMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baixo_peso);

        imc = findViewById(R.id.resultado_imc);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            IMC = extras.getFloat("imc_baixopeso");
        }

        imc.setText("Seu IMC atual é de " + IMC + ", portanto tua massa atual é considerada ABAIXO DO NORMAL. Busque aumentar a sua massa corporal, mantendo um nível adequado de atividade física, a prática de exercícios físicos, tal como uma alimentação adequada.");
    }
}