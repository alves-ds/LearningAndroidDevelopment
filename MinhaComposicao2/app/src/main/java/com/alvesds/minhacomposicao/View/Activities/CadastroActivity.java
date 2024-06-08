package com.alvesds.minhacomposicao.View.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.alvesds.minhacomposicao.Model.NovoUsuario;
import com.alvesds.minhacomposicao.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroActivity extends AppCompatActivity {

    Spinner sexos, ocupacoes;
    String sexo, ocupacao, userID;
    EditText novo_nome, nova_idade, novo_email, nova_senha;
    Button confirmar, cancelar;
    FirebaseAuth mAuth;
    DatabaseReference Myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Instancias();
        EntradaSexo();
        EntradaOcupacao();
        CadastrarNovo();
        CancelarCadastro();
    }

    public void Instancias() {
        sexos = findViewById(R.id.spinner_sexo);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Sexos, android.R.layout.simple_spinner_dropdown_item);
        sexos.setAdapter(adapter);
        ocupacoes = findViewById(R.id.spinner_ocupacao);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.Ocupacao, android.R.layout.simple_spinner_dropdown_item);
        ocupacoes.setAdapter(adapter2);
        novo_nome = findViewById(R.id.entrada_nome_usuario);
        nova_idade = findViewById(R.id.entrada_idade_usuario);
        novo_email = findViewById(R.id.entrada_email_usuario);
        nova_senha = findViewById(R.id.entrada_senha_usuario);
        confirmar = findViewById(R.id.confirmar_cadastro);
        cancelar = findViewById(R.id.cancelar_cadastro);
        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Myref = database.getReference();
        sexo = null;
        ocupacao = null;
    }

    private void EntradaSexo() {
        AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sexo = sexos.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };

        sexos.setOnItemSelectedListener(escolha);
    }

    private void EntradaOcupacao(){
        AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ocupacao = ocupacoes.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };

        ocupacoes.setOnItemSelectedListener(escolha);
    }

    private void CadastrarNovo() {
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!IsStringEmpty(novo_nome.getText().toString()) && (!IsStringEmpty(nova_idade.getText().toString())) && (!IsStringEmpty(novo_email.getText().toString())) && !IsStringEmpty(nova_senha.getText().toString()) && (!IsStringEmpty(sexo) && (!IsStringEmpty(ocupacao)))) {
                    mAuth.createUserWithEmailAndPassword(novo_email.getText().toString(), nova_senha.getText().toString())
                            .addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        assert user != null;
                                        userID = user.getUid();
                                        Toast.makeText(CadastroActivity.this, "Cadastro efetuado com sucesso!", Toast.LENGTH_LONG).show();
                                        SalvarInfo(userID, novo_nome.getText().toString(), nova_idade.getText().toString(), novo_email.getText().toString(), sexo, ocupacao);

                                        Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(CadastroActivity.this, "O Login falhou!", Toast.LENGTH_SHORT).show();
                                        updateUI(null);
                                    }
                                }
                            });
                } else {
                    Toast.makeText(CadastroActivity.this, "Não deixe nenhum campo em branco!", Toast.LENGTH_SHORT).show();
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

    private void updateUI(FirebaseUser currentUser) {
        Intent refresh = new Intent(CadastroActivity.this, CadastroActivity.class);
        startActivity(refresh);
    }

    private void SalvarInfo(String userID, String nome, String idade, String email, String sexo, String ocupacao) {
        NovoUsuario userinfo = new NovoUsuario(nome, idade, email, sexo, ocupacao);

        Myref.child("Users").child(userID).setValue(userinfo);
    }

    private void CancelarCadastro() {
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltar = new Intent(CadastroActivity.this, LoginActivity.class);
                Toast.makeText(CadastroActivity.this, "Cadastro cancelado com sucesso!", Toast.LENGTH_SHORT).show();
                startActivity(voltar);
            }
        });
    }
}