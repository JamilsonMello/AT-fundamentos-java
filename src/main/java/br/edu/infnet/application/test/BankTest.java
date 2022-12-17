package br.edu.infnet.application.test;

import br.edu.infnet.application.domain.Bank;
import br.edu.infnet.application.execeptions.AccountNotFoundExeception;
import br.edu.infnet.application.execeptions.BalanceValidationExeception;
import br.edu.infnet.application.execeptions.DepositValueExeception;
import br.edu.infnet.application.execeptions.ExistentAccountExeception;

public class BankTest {
    public static void main(String[] args) throws ExistentAccountExeception, AccountNotFoundExeception, DepositValueExeception, BalanceValidationExeception {
        Bank operation = new Bank();

        operation.openAccount(123, "jamilson");
        operation.closeAccount(123);
        operation.deposit(123, 1000);
        operation.getBalance(123);
        operation.transfer(123, 321, 1000);
        operation.withdraw(123, 1000);
    }
}
