package br.edu.infnet.application.test;

import br.edu.infnet.application.domain.Account;
import br.edu.infnet.application.execeptions.BalanceValidationExeception;
import br.edu.infnet.application.execeptions.DepositValueExeception;

public class AccountTest {
    public static void main(String[] args) throws BalanceValidationExeception, DepositValueExeception {
        String name = "João da Silva";
        int accountNumber = 1;
        
        Account account = new Account(accountNumber, name);

        account.deposit(accountNumber);
        account.getBalance();
        account.getOwnerName();
        account.withdraw(10);
    }
}
