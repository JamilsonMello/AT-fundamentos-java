package br.edu.infnet.application.domain;

import br.edu.infnet.application.execeptions.*;

public class Client {
    private String name;
    private int age;
    private Account account;

    public Client(String name, int age, Account account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public String getName() throws NameValidationExeception {
        if (name == null) {
            throw new NameValidationExeception("Error ao pegar o nome");
        }

        return name;
    }

    public int getAge() throws AgeValidationExeception {
        if (age < 18) {
            throw new AgeValidationExeception("O cliente deve ser maior de idade");
        }

        return age;
    }

    public Account getAccount() throws AccountValidationExeception {
        if (account == null) {
            throw new AccountValidationExeception("O cliente não possui uma conta");
        }

        return account;
    }
}