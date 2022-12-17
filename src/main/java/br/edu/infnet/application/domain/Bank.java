package br.edu.infnet.application.domain;

import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.application.execeptions.*;

public class Bank {
    private Map<Integer, Account> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void openAccount(int accountNumber, String ownerName) throws ExistentAccountExeception {
        // Crie uma nova conta e adicione-a ao mapa de contas
        Account targetAccount = accounts.get(accountNumber);

        if (targetAccount != null) {
            throw new ExistentAccountExeception("Conta existente");
        }

        Account newAccount = new Account(accountNumber, ownerName);
        accounts.put(accountNumber, newAccount);
    }

    public void closeAccount(int accountNumber) throws AccountNotFoundExeception {
        // Remova a conta do mapa de contas
        Account targetAccount = accounts.get(accountNumber);

        if (targetAccount != null) {
            accounts.remove(accountNumber);
        } else {
            throw new AccountNotFoundExeception("Conta inválida");
        }
    }

    public void deposit(int accountNumber, double amount) throws AccountNotFoundExeception, DepositValueExeception {
        // Encontre a conta especificada no mapa de contas
        Account targetAccount = accounts.get(accountNumber);

        // Realize o depósito na conta
        if (targetAccount != null) {
            targetAccount.deposit(amount);
        } else {
            throw new AccountNotFoundExeception("Conta inválida");
        }
    }

    public void withdraw(int accountNumber, double amount) throws BalanceValidationExeception, AccountNotFoundExeception {
        // Encontre a conta especificada no mapa de contas
        Account targetAccount = accounts.get(accountNumber);

        // Realize o saque da conta
        if (targetAccount != null) {
            targetAccount.withdraw(amount);
        } else {
            throw new AccountNotFoundExeception("Conta inválida");
        }
    }

    public double getBalance(int accountNumber) throws AccountNotFoundExeception {
        // Encontre a conta especificada no mapa de contas
        Account targetAccount = accounts.get(accountNumber);

        // Retorne o saldo da conta
        if (targetAccount != null) {
            return targetAccount.getBalance();
        } else {
            throw new AccountNotFoundExeception("Conta inválida");
        }
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) throws BalanceValidationExeception, AccountNotFoundExeception, DepositValueExeception {
        // Encontre as contas especificadas no mapa de contas
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);

        // Transfira o dinheiro entre as contas
        if (fromAccount != null && toAccount != null) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } else {
            throw new AccountNotFoundExeception("Conta inválida");
        }
    }
}