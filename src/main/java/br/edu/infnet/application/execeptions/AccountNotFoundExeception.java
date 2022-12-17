package br.edu.infnet.application.execeptions;

public class AccountNotFoundExeception extends Exception {

    public AccountNotFoundExeception(String mensagem) {
		super(mensagem);
	}
}
