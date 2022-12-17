package br.edu.infnet.application.domain;

import br.edu.infnet.application.execeptions.*;

public class Account {
    private int accountNumber;
    private String ownerName;
    private double balance;

    public Account(int accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    public void deposit(double amount) throws DepositValueExeception {
        if (amount < 10) {
            throw new DepositValueExeception("Valor não válido");
        }
        
        balance += amount;
    }

    public void withdraw(double amount) throws BalanceValidationExeception {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new BalanceValidationExeception("Saldo insuficiente");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getAccountNumber() {
        return accountNumber;
    }
}
