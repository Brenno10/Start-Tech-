package com.totvs.main;

import com.totvs.account.Conta;
import com.totvs.account.Corrente;
import com.totvs.account.Poupanca;
import com.totvs.tools.ScannerPlus;
import com.totvs.type.Fisica;
import com.totvs.type.Juridica;

public class Main {
    public static void main(String[] args) throws Exception {
        int type = ScannerPlus.readInt("""
                1- Pessoa Física
                2- Pessoa Jurídica
                """);
        Fisica fisica = null;
        Juridica juridica = null;

        Poupanca poupanca;
        Corrente corrente;

        if (type == 1) {
            String nome = ScannerPlus.readString("Digite o nome do cliente: ");
            String cpf = ScannerPlus.readString("Digite o CPF do cliente: ");
            String phone = ScannerPlus.readString("Digite o telefone do cliente: ");
            String eMail = ScannerPlus.readString("Digite o email do cliente: ");
            fisica = new Fisica(nome, cpf, phone, eMail);
        } else if (type == 2) {
            String nome = ScannerPlus.readString("Digite o nome fantasia do cliente: ");
            String razao = ScannerPlus.readString("Digite a razão social do cliente: ");
            String cnpj = ScannerPlus.readString("Digite o CNPJ do cliente: ");
            String eMail = ScannerPlus.readString("Digite o email do cliente: ");
            juridica = new Juridica(nome, razao, cnpj, eMail);
        }

        String account = "";
        boolean valid = true;
        do {
            int accType = ScannerPlus.readInt("""
                                    
                    1- Conta Corrente
                    2- Conta Poupança
                    """);
            if (accType == 1) {
                double deposit = ScannerPlus.readDouble("Digite o depósito");
                poupanca = new Poupanca(deposit, Conta.createNewAccId());
                account = poupanca.getYeld();
                valid = true;
            } else if (accType == 2) {
                double deposit = ScannerPlus.readDouble("Digite o depósito");
                corrente = new Corrente(deposit, Conta.createNewAccId());
                account = corrente.getYeld();
                valid = true;
            } else {
                System.out.println("Não é uma conta válida");
                valid = false;
            }
        } while (!valid);

        if (fisica != null) {
            System.out.printf("""
                    
                    Cliente: %s
                    CPF: %s
                    Telefone: %s
                    E-Mail: %s
                    %s
                    """,
                    fisica.getNome(), fisica.getCpf(), fisica.getPhone(), fisica.geteMail(), account);
        } else if (juridica != null) {
            System.out.printf("""
                    
                    Cliente: %s
                    Razão Social: %s
                    CNPJ: %s
                    E-Mail: %s
                    %s
                    """,
                    juridica.getNome(), juridica.getReason(), juridica.getCnpj(), juridica.geteMail(), account);
        } else {
            throw new Exception("Pessoa não encontrada");
        }
    }
}
