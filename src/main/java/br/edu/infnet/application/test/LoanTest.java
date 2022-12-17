package br.edu.infnet.application.test;

import java.util.Date;

import br.edu.infnet.application.domain.Loan;
import br.edu.infnet.application.execeptions.DepositValueExeception;
import br.edu.infnet.application.execeptions.TermValueNotValidExeception;

public class LoanTest {
    public static void main(String[] args) throws DepositValueExeception, TermValueNotValidExeception {
        double amount = 1000.0;
        double interestRate = 12.0;
        int term = 48; // em meses
        Date startDate = new Date();
        
        Loan account1 = new Loan(amount, interestRate, term, startDate);
        Loan account2 = new Loan(2.0, interestRate, term, startDate);
        Loan account3 = new Loan(amount, interestRate, 1, startDate);
     
        account1.getMonthlyPayment();
        account1.getTotalPayment();
        account1.getMonthlyPayment();

        account2.getMonthlyPayment();
        account2.getTotalPayment();
        account2.getMonthlyPayment();

        account3.getMonthlyPayment();
        account3.getTotalPayment();
        account3.getMonthlyPayment();
    }
}
