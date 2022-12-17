package br.edu.infnet.application.test;

import br.edu.infnet.application.domain.*;
import br.edu.infnet.application.execeptions.AccountValidationExeception;
import br.edu.infnet.application.execeptions.AgeValidationExeception;
import br.edu.infnet.application.execeptions.NameValidationExeception;

public class ClientTest {
    public static void main(String[] args) throws AccountValidationExeception, AgeValidationExeception, NameValidationExeception {
        String name = "João da Silva";
        int age = 35;
        
        Account account = new Account(1, name);
        Client client1 = new Client(name, age, account);
        Client client2 = new Client(name, 15, account);
        Client client3 = new Client(name, age, null);

        client1.getAccount();
        client1.getAge();
        client1.getName();

        client2.getAccount();
        client2.getAge();
        client2.getName();

        client3.getAccount();
        client3.getAge();
        client3.getName();
    }
}
