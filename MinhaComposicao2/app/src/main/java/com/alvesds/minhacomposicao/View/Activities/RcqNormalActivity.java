package com.alvesds.minhacomposicao.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alvesds.minhacomposicao.R;

public class RcqNormalActivity extends AppCompatActivity {

    TextView rcq_normal;
    Float ft_rcq_normal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcq_normal);

        rcq_normal = findViewById(R.id.resultado_rcq_normal);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ft_rcq_normal = extras.getFloat("rcq_normal");
        }

        rcq_normal.setText("Seu RCQ atual é de " + ft_rcq_normal + ", este valor é considerado normal, e representa um baixo risco cardiovascular. Busque realizar a manutenção ou reduzí-lo por meio da prática de atividades físicas e exercícios, tal como por uma alimentação adequada por meio de um acompanhamento profissional.");
    }
}