package com.totvs.type;

public abstract class Pessoa {
    protected String nome;
    protected String eMail;

    public Pessoa(String nome, String eMail) {
        this.nome = nome;
        this.eMail = eMail;
    }

    public String getNome() {
        return nome;
    }

    public String geteMail() {
        return eMail;
    }
}
