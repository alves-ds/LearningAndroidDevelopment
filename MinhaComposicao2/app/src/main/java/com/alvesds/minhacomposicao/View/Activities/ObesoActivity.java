package com.alvesds.minhacomposicao.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alvesds.minhacomposicao.R;

public class ObesoActivity extends AppCompatActivity {

    TextView imc;
    float IMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obeso);

        imc = findViewById(R.id.resulado_imc_obeso);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            IMC = extras.getFloat("imc_obeso");
        }

        imc.setText("Seu IMC atual é de " + IMC + ", portanto você é atualmente considerado OBESO. Busque reduzir sua massa atual, por meio de um aumento no seu atual nível de atividade física, a prática de exercícios físicos, tal como uma alimentação adequada.");
    }
}