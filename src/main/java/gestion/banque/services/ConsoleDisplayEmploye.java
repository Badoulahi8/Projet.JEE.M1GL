package gestion.banque.services;

import gestion.banque.domain.Client;
import gestion.banque.domain.Employe;
import gestion.banque.repository.ClientRepository;
import gestion.banque.repository.CompteRepository;
import gestion.banque.repository.EmployeRepository;
import gestion.banque.repository.jdbc.JdbcBasedClientRepository;
import gestion.banque.repository.jdbc.JdbcBasedCompteRepository;
import gestion.banque.repository.jdbc.JdbcBasedEmployeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleDisplayEmploye implements DisplayEmploye {
    private ClientRepository clientRepository ;
    private EmployeRepository employeRepository ;
    DisplayCompte displayCompte ;
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void listerInfos() {
        clientRepository = new JdbcBasedClientRepository();
        System.out.println("INFORMATIONS DES CLIENTS");
        List<Client> clients = new ArrayList<Client>();
        clients = clientRepository.allClient();
        for (Client c : clients)
        {
            clientRepository.detailClient(c);
        }
    }

    @Override
    public void infoClient() {
        displayCompte = new ConsoleDisplayCompte();
        clientRepository = new JdbcBasedClientRepository();
        System.out.println("Methode info");
        String numero= "";
        do {
            System.out.println("Donner le numero du client");
            numero = displayCompte.saisieNumCompte();
        }while(numero.equals(""));
        clientRepository.detailClient(clientRepository.getClientByNum(numero));
    }

    @Override
    public void listerOperation() {
        System.out.println("Methode liste operation");
    }

    @Override
    public String saisielogin() {
        String login = "";
        do {
            System.out.println("Saisir votre login");
            login = scanner.next();
        }while(login.equals(""));
        return login;
    }

    @Override
    public String saisiePassword() {
        String password = "";
        do {
            System.out.println("Saisir votre mot de password");
            password = scanner.next();
        }while(password.equals(""));
        return password;
    }

    @Override
    public Employe connexion() {
        employeRepository = new JdbcBasedEmployeRepository();
        return employeRepository.connection(saisielogin(),saisiePassword());
    }
}
