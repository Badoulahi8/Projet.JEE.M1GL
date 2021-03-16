package gestion.banque.services;

import gestion.banque.domain.Client;
import gestion.banque.domain.Employe;
import gestion.banque.repository.ClientRepository;
import gestion.banque.repository.CompteRepository;
import gestion.banque.repository.jdbc.JdbcBasedClientRepository;
import gestion.banque.repository.jdbc.JdbcBasedCompteRepository;

import java.util.ArrayList;
import java.util.List;

public class ConsoleDisplayEmploye implements DisplayEmploye {
    private ClientRepository clientRepository ;
    private CompteRepository compteRepository ;
    DisplayCompte displayCompte ;
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
        compteRepository = new JdbcBasedCompteRepository();
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
    public Employe saisieEmploye() {
        return null;
    }
}
