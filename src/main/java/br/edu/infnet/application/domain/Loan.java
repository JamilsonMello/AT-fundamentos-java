package br.edu.infnet.application.domain;

import java.util.Date;

import br.edu.infnet.application.execeptions.*;

public class Loan {
    private double amount;
    private double interestRate;
    private int term; // em meses
    private Date startDate;

    public Loan(double amount, double interestRate, int term, Date startDate) throws DepositValueExeception, TermValueNotValidExeception {
        if (amount < 100) {
            throw new DepositValueExeception("O valor não é válido");
        }

        if (term < 6) {
            throw new TermValueNotValidExeception("Quantidade de parcelas não válido");
        }

        this.amount = amount;
        this.interestRate = interestRate;
        this.term = term;
        this.startDate = startDate;
    }

    public double getMonthlyPayment() {
        // Calcule o pagamento mensal usando a fórmula:
        // P = (r * A) / (1 - (1 + r)^(-n))
        // onde:
        // P = pagamento mensal
        // r = taxa de juros mensal (interestRate/12)
        // A = valor do empréstimo (amount)
        // n = número de meses (term)
        double monthlyInterestRate = interestRate / 12;
        double monthlyPayment = (monthlyInterestRate * amount) / (1 - Math.pow(1 + monthlyInterestRate, -term));
        return monthlyPayment;
    }

    public double getTotalPayment() {
        // Calcule o pagamento total como o pagamento mensal multiplicado pelo número de meses
        return getMonthlyPayment() * term;
    }

    public Date getStartDate() {
        return startDate;
    }
}