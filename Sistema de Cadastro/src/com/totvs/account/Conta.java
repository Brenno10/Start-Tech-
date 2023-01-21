package com.totvs.account;

public abstract class Conta {
    private static int currentId = 0;
    protected double deposit;
    protected int id;

    public Conta(double deposit, int id) {
        this.id = id;
        this.deposit = deposit;
    }

    public double getDeposit() {
        return deposit;
    }

    public int getId() {
        return id;
    }

    public static int createNewAccId() {
        currentId++;
        return currentId;
    }

    public double calculate() {
        return 0;
    }

    public String getYeld() {
        return "";
    }
}
