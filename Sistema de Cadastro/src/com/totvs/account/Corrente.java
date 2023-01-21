package com.totvs.account;

public class Corrente extends Conta {
    public Corrente(double deposit, int id) {
        super(deposit, id);
    }

    @Override
    public double calculate() {
        return this.getDeposit() * 0.1;
    }

    @Override
    public String getYeld() {
        return String.format("""
                
                Conta Corrente: %s
                Saldo: R$%.2f
                Rendimento para o próximo mês: R$%.2f
                """,
                this.getId(), this.getDeposit(), this.calculate());
    }
}
