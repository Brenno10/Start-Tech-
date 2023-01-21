package com.totvs.account;

public class Poupanca extends Conta {
    public Poupanca(double deposit, int id) {
        super(deposit, id);
    }

    @Override
    public double calculate() {
        return this.getDeposit() * 0.05;
    }

    @Override
    public String getYeld() {
        return String.format("""
                
                Conta Corrente: %s
                Saldo: R$%.2f
                Cheque Especial: R$%.2f
                """,
                this.getId(), this.getDeposit(), this.calculate());
    }
}
