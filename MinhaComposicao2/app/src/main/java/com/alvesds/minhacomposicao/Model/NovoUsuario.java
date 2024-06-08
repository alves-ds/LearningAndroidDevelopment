package com.alvesds.minhacomposicao.Model;

public class NovoUsuario {

    public String nome;
    public String idade;
    public String email;
    public String sexo;
    public String ocupacao;

    public NovoUsuario(){

    }

    public NovoUsuario(String nome, String idade, String email, String sexo, String ocupacao) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.sexo = sexo;
        this.ocupacao = ocupacao;
    }
}
