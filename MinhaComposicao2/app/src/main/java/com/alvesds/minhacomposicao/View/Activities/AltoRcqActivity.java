package com.alvesds.minhacomposicao.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alvesds.minhacomposicao.R;

public class AltoRcqActivity extends AppCompatActivity {

    TextView rcq;
    Float ft_rcq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alto_rcq);

        rcq = findViewById(R.id.resultado_rcq_alto);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ft_rcq = extras.getFloat("rcq_alto");
        }

        rcq.setText("Seu RCQ atual é de " + ft_rcq + ", este valor é considerado elevado, e representa um risco cardiovascular aumentado. Busque reduzí-lo por meio da prática de atividades físicas e exercícios, tal como por uma alimentação adequada por meio de um acompanhamento profissional.");
    }
}