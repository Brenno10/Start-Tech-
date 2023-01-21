package com.totvs.type;

public class Fisica extends Pessoa {
    protected String cpf, phone;

    public Fisica(String nome, String cpf, String phone, String eMail) {
        super(nome, eMail);
        this.cpf = cpf;
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhone() {
        return phone;
    }
}
