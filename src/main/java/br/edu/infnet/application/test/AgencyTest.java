package br.edu.infnet.application.test;

import br.edu.infnet.application.domain.*;

public class AgencyTest {
    public static void main(String[] args) {
        Agency agency1 = new Agency();
        Agency agency2 = new Agency();
        Agency agency3 = new Agency();

        agency1.setCity("Fortaleza");
        agency1.setState("Ceará");
        agency1.setCode(1233);
        agency1.getLocale();

        agency2.setCity("Recife");
        agency2.setState("Pernambuco");
        agency2.setCode(1232);
        agency2.getLocale();

        agency3.setCity("Natal");
        agency3.setState("Rio Grande do Norte");
        agency3.setCode(1432);
        agency3.getLocale();
    }
}
