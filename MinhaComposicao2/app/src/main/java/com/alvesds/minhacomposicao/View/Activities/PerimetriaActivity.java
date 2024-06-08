package com.alvesds.minhacomposicao.View.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alvesds.minhacomposicao.R;

public class PerimetriaActivity extends AppCompatActivity {

    EditText entrada_braco_esq, entrada_braco_dir, entrada_antebraco_esq, entrada_antebraco_dir, entrada_coxa_prox_esq, entrada_coxa_prox_dir, entrada_coxa_med_esq, entrada_coxa_med_dir, entrada_coxa_dist_esq, entrada_coxa_dist_dir, entrada_panturrilha_esq, entrada_panturrilha_dir, entrada_torax, entrada_cintura, entrada_abdominal;
    Button calcular_diferenca_perimetria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perimetria);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Instancias();
        CalcularDiferencas();
    }

    private void Instancias() {
        entrada_braco_esq = findViewById(R.id.entrada_circunferencia_braco_esq);
        entrada_braco_dir = findViewById(R.id.entrada_circunferencia_braco_dir);
        entrada_antebraco_esq = findViewById(R.id.entrada_antebraco_esq);
        entrada_antebraco_dir = findViewById(R.id.entrada_antebraco_dir);
        entrada_coxa_prox_esq = findViewById(R.id.entrada_circunferencia_coxa_prox_esq);
        entrada_coxa_prox_dir = findViewById(R.id.entrada_circunferencia_coxa_prox_dir);
        entrada_coxa_med_esq = findViewById(R.id.entrada_circunferencia_coxa_med_esq);
        entrada_coxa_med_dir = findViewById(R.id.entrada_circunferencia_coxa_med_dir);
        entrada_coxa_dist_esq = findViewById(R.id.entrada_circunferencia_coxa_dist_esq);
        entrada_coxa_dist_dir = findViewById(R.id.entrada_circunferencia_coxa_dist_dir);
        entrada_panturrilha_esq = findViewById(R.id.entrada_circunferencia_panturrilha_esq);
        entrada_panturrilha_dir = findViewById(R.id.entrada_circunferencia_panturrilha_dir);
        entrada_torax = findViewById(R.id.entrada_circunferencia_torax);
        entrada_cintura = findViewById(R.id.entrada_circunferencia_cintura);
        entrada_abdominal = findViewById(R.id.entrada_circunferencia_abd);
        calcular_diferenca_perimetria = findViewById(R.id.botao_calcular_diferencas_perimetria);
    }

    private void CalcularDiferencas() {
        calcular_diferenca_perimetria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bracoesq = entrada_braco_esq.getText().toString();
                String bracodir = entrada_braco_dir.getText().toString();
                String antebracoesq = entrada_antebraco_esq.getText().toString();
                String antebracodir = entrada_antebraco_dir.getText().toString();
                String coxaproxesq = entrada_coxa_prox_esq.getText().toString();
                String coxaproxdir = entrada_coxa_prox_dir.getText().toString();
                String coxamedesq = entrada_coxa_med_esq.getText().toString();
                String coxameddir = entrada_coxa_med_dir.getText().toString();
                String coxadistesq = entrada_coxa_dist_esq.getText().toString();
                String coxadistdir = entrada_coxa_dist_dir.getText().toString();
                String panturrilhaesq = entrada_panturrilha_esq.getText().toString();
                String panturrilhadir = entrada_panturrilha_dir.getText().toString();
                String torax = entrada_torax.getText().toString();
                String cintura = entrada_cintura.getText().toString();
                String abdominal = entrada_abdominal.getText().toString();

                if ((!IsStringEmpty(bracoesq)) && (!IsStringEmpty(bracodir)) && (!IsStringEmpty(antebracoesq)) && (!IsStringEmpty(antebracodir)) && (!IsStringEmpty(coxaproxesq)) && (!IsStringEmpty(coxaproxdir)) && (!IsStringEmpty(coxamedesq)) && (!IsStringEmpty(coxameddir)) && (!IsStringEmpty(coxadistesq)) && (!IsStringEmpty(coxadistdir)) && (!IsStringEmpty(panturrilhaesq)) && (!IsStringEmpty(panturrilhadir)) && (!IsStringEmpty(torax)) && (!IsStringEmpty(cintura)) && (!IsStringEmpty(abdominal))) {
                    float bracoesqnum = Float.parseFloat(bracoesq);
                    float bracodirqnum = Float.parseFloat(bracodir);
                    float antebracoesqnum = Float.parseFloat(antebracoesq);
                    float antebracodirnum = Float.parseFloat(antebracodir);
                    float coxaproxesqnum = Float.parseFloat(coxaproxesq);
                    float coxaproxdirnum = Float.parseFloat(coxaproxdir);
                    float coxamedesqnum = Float.parseFloat(coxamedesq);
                    float coxameddirnum = Float.parseFloat(coxameddir);
                    float coxadistesqnum = Float.parseFloat(coxadistesq);
                    float coxadistdirnum = Float.parseFloat(coxadistdir);
                    float panturrilhaesqnum = Float.parseFloat(panturrilhaesq);
                    float panturrilhadirnum = Float.parseFloat(panturrilhadir);

                    if ((Float.compare(bracoesqnum, bracodirqnum) != 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent bracos_diferentes = new Intent(PerimetriaActivity.this, BracosDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Seus braços são diferentes", Toast.LENGTH_LONG).show();
                        startActivity(bracos_diferentes);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) != 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent antebracos_diferentes = new Intent(PerimetriaActivity.this, AntebracosDiferentesActivity.class);
                        Toast.makeText(PerimetriaActivity.this, "Seus antebraços são diferentes", Toast.LENGTH_LONG).show();
                        startActivity(antebracos_diferentes);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) != 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent coxa_prox_diferente = new Intent(PerimetriaActivity.this, CoxaProximalDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Sua coxa proximal é diferente", Toast.LENGTH_LONG).show();
                        startActivity(coxa_prox_diferente);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) != 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent coxa_med_diferente = new Intent(PerimetriaActivity.this, CoxaMedialDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Sua coxa medial é diferente", Toast.LENGTH_LONG).show();
                        startActivity(coxa_med_diferente);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) != 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent coxa_dist_diferente = new Intent(PerimetriaActivity.this, CoxaDistalDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Sua coxa distal é diferente", Toast.LENGTH_LONG).show();
                        startActivity(coxa_dist_diferente);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) != 0)) {
                        Intent panturrilhas_diferentes = new Intent(PerimetriaActivity.this, PanturrilhaDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Suas panturrilhas são diferentes", Toast.LENGTH_LONG).show();
                        startActivity(panturrilhas_diferentes);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) != 0) && (Float.compare(antebracoesqnum, antebracodirnum) != 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent bracos_e_antebracos = new Intent(PerimetriaActivity.this, BracoAntebracoDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Seus braços e antebraços são diferentes", Toast.LENGTH_LONG).show();
                        startActivity(bracos_e_antebracos);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) != 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) != 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent braco_e_coxa_prox = new Intent(PerimetriaActivity.this, BracoCoxaProximalDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Seus braços e coxa proximal", Toast.LENGTH_LONG).show();
                        startActivity(braco_e_coxa_prox);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) != 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) != 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent braco_e_coxa_medial = new Intent(PerimetriaActivity.this, BracoCoxaMedialDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Braço e coxa medial", Toast.LENGTH_LONG).show();
                        startActivity(braco_e_coxa_medial);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) != 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) != 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent braco_e_coxa_distal = new Intent(PerimetriaActivity.this, BracoCoxaDistalDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Braço e coxa distal", Toast.LENGTH_LONG).show();
                        startActivity(braco_e_coxa_distal);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) != 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) != 0)) {
                        Intent bracos_e_panturrilha = new Intent(PerimetriaActivity.this, BracoPanturrilhaDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Braços e panturrilha", Toast.LENGTH_LONG).show();
                        startActivity(bracos_e_panturrilha);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) != 0) && (Float.compare(coxamedesqnum, coxameddirnum) != 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent coxa_prox_e_med = new Intent(PerimetriaActivity.this, CoxaProximalEMedialDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Coxa Proximal e medial", Toast.LENGTH_LONG).show();
                        startActivity(coxa_prox_e_med);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) != 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) != 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent coxa_proximal_e_distal = new Intent(PerimetriaActivity.this, CoxaProximalEDistalDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Coxa Proximal e distal", Toast.LENGTH_LONG).show();
                        startActivity(coxa_proximal_e_distal);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) != 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) != 0)) {
                        Intent coxa_prox_e_panturrilha = new Intent(PerimetriaActivity.this, CoxaProximalEPanturrilhasDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Coxa Proximal e panturrilha", Toast.LENGTH_LONG).show();
                        startActivity(coxa_prox_e_panturrilha);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) != 0) && (Float.compare(coxadistesqnum, coxadistdirnum) != 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent coxa_medial_e_distal = new Intent(PerimetriaActivity.this, CoxaMedialeDistalDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Coxa medial e distal", Toast.LENGTH_LONG).show();
                        startActivity(coxa_medial_e_distal);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) != 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) != 0)) {
                        Intent coxa_medial_e_panturrilha = new Intent(PerimetriaActivity.this, CoxaMedialPanturrilhaDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Coxa medial e panturrilha", Toast.LENGTH_LONG).show();
                        startActivity(coxa_medial_e_panturrilha);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) == 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) != 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) != 0)) {
                        Intent coxa_distal_e_panturrilha = new Intent(PerimetriaActivity.this, CoxaDistalPanturrilhaDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Coxa distal e panturrilha", Toast.LENGTH_LONG).show();
                        startActivity(coxa_distal_e_panturrilha);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) != 0) && (Float.compare(antebracoesqnum, antebracodirnum) != 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) != 0) && (Float.compare(coxamedesqnum, coxameddirnum) != 0) && (Float.compare(coxadistesqnum, coxadistdirnum) != 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) != 0)) {
                        Intent todos_membros = new Intent(PerimetriaActivity.this, TodosMembrosDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Todos membros", Toast.LENGTH_LONG).show();
                        startActivity(todos_membros);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) != 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) != 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent antebraco_e_coxa_proximal = new Intent(PerimetriaActivity.this, AntebracoCoxaProximalDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Antebraço e coxa proximal", Toast.LENGTH_LONG).show();
                        startActivity(antebraco_e_coxa_proximal);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) != 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) != 0) && (Float.compare(coxadistesqnum, coxadistdirnum) == 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent antebraco_e_coxa_medial = new Intent(PerimetriaActivity.this, AntebracoCoxaMedialDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Antebraço e coxa medial", Toast.LENGTH_LONG).show();
                        startActivity(antebraco_e_coxa_medial);

                    }
                    if ((Float.compare(bracoesqnum, bracodirqnum) == 0) && (Float.compare(antebracoesqnum, antebracodirnum) != 0) && (Float.compare(coxaproxesqnum, coxaproxdirnum) == 0) && (Float.compare(coxamedesqnum, coxameddirnum) == 0) && (Float.compare(coxadistesqnum, coxadistdirnum) != 0) && (Float.compare(panturrilhaesqnum, panturrilhadirnum) == 0)) {
                        Intent antebraco_e_coxa_distal = new Intent(PerimetriaActivity.this, AntebracoCoxaDistalDiferentes.class);
                        Toast.makeText(PerimetriaActivity.this, "Antebraco e coxa distal", Toast.LENGTH_LONG).show();
                        startActivity(antebraco_e_coxa_distal);

                    }
                    else {
                        Toast.makeText(PerimetriaActivity.this, "Nenhum dos seus membros é diferente", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(PerimetriaActivity.this, "Não deixe nenhum campo em branco!", Toast.LENGTH_SHORT).show();
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