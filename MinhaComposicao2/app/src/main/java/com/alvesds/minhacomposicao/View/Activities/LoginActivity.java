package com.alvesds.minhacomposicao.View.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alvesds.minhacomposicao.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextView cadastro;
    EditText email, senha;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        login = findViewById(R.id.botao_entrar);
        cadastro = findViewById(R.id.botao_criar_conta);
        email = findViewById(R.id.login_email);
        senha = findViewById(R.id.login_senha);

        Cadastrar();
        Login();
    }

    private void Cadastrar(){
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastro = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(cadastro);
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

    private void Login() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!IsStringEmpty(email.getText().toString()) && (!IsStringEmpty(senha.getText().toString()))) {

                    mAuth.signInWithEmailAndPassword(email.getText().toString(), senha.getText().toString())
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Intent intent = new Intent(LoginActivity.this, TelaPrincipalActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Confira suas credenciais!",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(LoginActivity.this, "Não deixe nenhum campo em branco!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}