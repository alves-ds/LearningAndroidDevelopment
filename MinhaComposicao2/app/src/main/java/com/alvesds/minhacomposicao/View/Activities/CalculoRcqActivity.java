package com.alvesds.minhacomposicao.View.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.alvesds.minhacomposicao.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import java.util.Objects;

public class CalculoRcqActivity extends AppCompatActivity {

    String sexo_rcq, user;
    EditText cintura, quadril;
    Float ft_cintura, ft_quadril, rcq;
    Button calcular;
    DatabaseReference Myref;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_rcq);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Myref = database.getReference();
        user = mAuth.getCurrentUser().getUid();

    }

    @Override
    public void onResume() {
        super.onResume();
        cintura = findViewById(R.id.entrada_circunferencia_cintura);
        quadril = findViewById(R.id.entrada_circunferencia_quadril);
        calcular = findViewById(R.id.botao_calcular_rcq);
        RecuperarDados();
        CalculoRcq();
    }

    public void RecuperarDados(){
        Myref.child("Users").child(user).child("sexo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String sexoRcq = snapshot.getValue(String.class);
                sexo_rcq = sexoRcq;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
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

    private void CalculoRcq() {
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((!IsStringEmpty(cintura.getText().toString())) && (!IsStringEmpty(quadril.getText().toString()))) {
                    ft_cintura = Float.parseFloat(cintura.getText().toString());
                    ft_quadril = Float.parseFloat(quadril.getText().toString());
                    rcq = ft_cintura / ft_quadril;

                    if ((rcq >= 0.90) && (sexo_rcq.equals("Macho"))) {
                        Intent rcq_alto1 = new Intent(CalculoRcqActivity.this, AltoRcqActivity.class);
                        rcq_alto1.putExtra("rcq_alto", rcq);
                        startActivity(rcq_alto1);
                    }

                    if ((rcq >= 0.85) && (sexo_rcq.equals("Fêmea"))) {
                        Intent rcq_alto = new Intent(CalculoRcqActivity.this, AltoRcqActivity.class);
                        rcq_alto.putExtra("rcq_alto", rcq);
                        startActivity(rcq_alto);
                    }

                    if ((rcq < 0.90) && (sexo_rcq.equals("Macho"))) {
                        Intent rcq_normal1 = new Intent(CalculoRcqActivity.this, RcqNormalActivity.class);
                        rcq_normal1.putExtra("rcq_normal", rcq);
                        startActivity(rcq_normal1);
                    }

                    if ((rcq < 0.85) && (sexo_rcq.equals("Fêmea"))) {
                        Intent rcq_normal = new Intent(CalculoRcqActivity.this, RcqNormalActivity.class);
                        rcq_normal.putExtra("rcq_normal", rcq);
                        startActivity(rcq_normal);
                    }
                } else {
                    Toast.makeText(CalculoRcqActivity.this, "Não deixe nenhum campo em branco!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}