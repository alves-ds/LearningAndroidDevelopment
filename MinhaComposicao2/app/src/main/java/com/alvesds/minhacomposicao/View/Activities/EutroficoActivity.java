package com.alvesds.minhacomposicao.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alvesds.minhacomposicao.R;

public class EutroficoActivity extends AppCompatActivity {

    TextView imc;
    float IMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eutrofico);

        imc = findViewById(R.id.resulado_imc_eutrofico);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            IMC = extras.getFloat("imc_eutrofico");
        }

        imc.setText("Seu IMC atual é de " + IMC +", portanto você é atualmente considerado EUTRÓFICO. Busque realizar a manutenção da sua massa atual, mantendo um alto nível de atividade física, a prática de exercícios físicos, tal como uma alimentação adequada.");
    }
}