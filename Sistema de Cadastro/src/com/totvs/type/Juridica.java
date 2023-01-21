package com.totvs.type;

public class Juridica extends Pessoa {
    protected String reason, cnpj;

    public Juridica(String nome, String reason, String cnpj, String eMail) {
        super(nome, eMail);
        this.reason = reason;
        this.cnpj = cnpj;
    }

    public String getReason() {
        return reason;
    }

    public String getCnpj() {
        return cnpj;
    }
}
