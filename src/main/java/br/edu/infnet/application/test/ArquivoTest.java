package br.edu.infnet.application.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

import br.edu.infnet.application.domain.Account;
import br.edu.infnet.application.domain.Client;
import br.edu.infnet.application.execeptions.NameValidationExeception;

public class ArquivoTest {
    public static void main(String[] args) throws NameValidationExeception, URISyntaxException {
        try {

			try {
				String dir = new File("").getAbsolutePath();		
				String arq = "clients.txt";
				
				FileReader file = new FileReader(dir+"/"+arq);
				BufferedReader leitura = new BufferedReader(file);
				
				FileWriter fileW = new FileWriter(dir+"/out_total_de_clientes_"+arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String linha = leitura.readLine();
				
				String[] campos = null;
				
				int qtde = 0;
				
				while(linha != null) {
					
					campos = linha.split(";");

					switch (campos[0].toUpperCase()) {
					case "C":
                        String name = campos[1];
                        int age = Integer.valueOf(campos[2]);
                        int accountNumber = Integer.valueOf(campos[3]);
                        Account account = new Account(accountNumber, name);

                        Client client = new Client(name, age, account);

                        System.out.println("Cliente: [" + client.getName() + "]");

						qtde++;

						break;
						
					default:
						System.out.println("Funcionário ainda não definido [" + linha + "]");
						break;
					}

					linha = leitura.readLine();
				}
				
				escrita.write("total de clientes: "+qtde+"\r\n");
								
				leitura.close();
				file.close();
				escrita.close();
				fileW.close();
			} catch (IOException e) {
				System.out.println("[ERROR] " + e.getMessage());
			}

		} finally {
			System.out.println("Processamento realizado com sucesso!!!");
		}
    }
}
