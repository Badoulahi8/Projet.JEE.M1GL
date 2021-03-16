package gestion.banque.services;

import gestion.banque.domain.Client;
import gestion.banque.domain.Compte;
import gestion.banque.repository.ClientRepository;
import gestion.banque.repository.CompteRepository;
import gestion.banque.repository.jdbc.JdbcBasedClientRepository;
import gestion.banque.repository.jdbc.JdbcBasedCompteRepository;

import java.util.Scanner;

public class ConsoleDisplayClient implements DisplayClient {
    private Scanner scanner = new Scanner(System.in) ;
    private Client client = null ;
    private Compte cmp = null ;
    private ClientRepository clientRepository ;
    private CompteRepository compteRepository ;
    private DisplayCompte displayCompte;
    private String rep = "" ;

    @Override
    public Client saisieClient() {
        String nom= "";
        String adresse= "";
        String telephone= "";
        do {
            System.out.println("Donner le nom du client");
            nom = scanner.next();
        }while(nom.equals(""));

        do {
        System.out.println("Donner l'adresse du client");
        adresse = scanner.next();
        }while(adresse.equals(""));

        do {
        System.out.println("Donner le numero de telephone du client");
        telephone = scanner.next();
        }while(telephone.equals(""));

        client = new Client();
        clientRepository = new JdbcBasedClientRepository();
        client.setNumeroClient("NUM-000"+(clientRepository.getNewNum()+1));
        client.setNomClient(nom);
        client.setAdresseClient(adresse);
        client.setTelephoneClient(telephone);
        return client ;
    }

    @Override
    public void consulterCompte() {
        //System.out.println("INFORMATION DU COMPTE");
        displayCompte = new ConsoleDisplayCompte();
        compteRepository = new JdbcBasedCompteRepository();
        client = new Client();
        String num = "";
        num = displayCompte.saisieNumCompte();
        cmp = new Compte();
        cmp = compteRepository.getCompteByNum(num);
        if(cmp != null)
        {
            clientRepository = new JdbcBasedClientRepository();
            client = clientRepository.getClientByNum(cmp.getClient().getNumeroClient());
            System.out.println("----------INFORMATION DU CLIENT----------------");
            System.out.println("ID : "+client.getIdClient());
            System.out.println("NOM : "+client.getNomClient());
            System.out.println("ADRESSE : "+client.getAdresseClient());
            System.out.println("TELEPHONE : "+client.getTelephoneClient());
            System.out.println("----------INFORMATION DU COMPTE----------------");
            System.out.println("NUMERO : "+cmp.getNumeroCompte());
            System.out.println("MONTANT : "+cmp.getMontantCompte());
            //System.out.println("DATE OUVERTURE : "+cmp.getDateCreation());
        }
        else
        {
            System.out.println("Numero du compte est incorrect !!!");
        }
    }

    @Override
    public void inscrire() {
        System.out.println("INTERFACE D'INSCRIPTION A UN NOUVEAU COMPTE");
        client = new Client();
        client = saisieClient();
        clientRepository = new JdbcBasedClientRepository();
        compteRepository = new JdbcBasedCompteRepository();
        if(clientRepository.addClient(client) == 0)
        {
            System.out.println("ECHEC INSCRIPTION");
        }
        else
        {
            System.out.println("INSCRIPTION DU CLIENT REUSSIE");

            if(compteRepository.addCompte(client) != 0)
            {
                System.out.println("VOTRE EST MAINTENANT ACTIF");
            }
            else
            {
                System.out.println("COMPTE NON CREE");
            }
        }
    }

    @Override
    public void depot() {
        System.out.println("INTERFACE DE DEPOT D'ARGENT");
        displayCompte = new ConsoleDisplayCompte();
        compteRepository = new JdbcBasedCompteRepository();
        client = new Client();
        String num = "";
        num = displayCompte.saisieNumCompte();
        cmp = new Compte();
        cmp = compteRepository.getCompteByNum(num);
        if(cmp != null)
        {
            int mnt = 0 ;
            mnt = displayCompte.saisieMontant();
            compteRepository.depot(cmp,mnt);
            System.out.println("OPERATION DE DEPOT REUSSIE");
        }
        else
        {
            System.out.println("NUMERO DE COMPTE EST INCORRECTE !!!");
        }

    }

    @Override
    public void retrait() {
        System.out.println("INTERFACE DE RETRAITE D'ARGENT");
        displayCompte = new ConsoleDisplayCompte();
        compteRepository = new JdbcBasedCompteRepository();
        client = new Client();
        String num = "";
        num = displayCompte.saisieNumCompte();
        cmp = new Compte();
        cmp = compteRepository.getCompteByNum(num);
        if(cmp != null)
        {
            int mnt = 0 ;
            mnt = displayCompte.saisieMontant();
            compteRepository.retrait(cmp,mnt);
            System.out.println("OPERATION DE RETRAITE REUSSIE");
        }
        else
        {
            System.out.println("NUMERO DE COMPTE EST INCORRECTE !!!");
        }
    }

    @Override
    public void virement() {
        System.out.println("INTERFACE DE VIREMENT D'ARGENT");
        displayCompte = new ConsoleDisplayCompte();
        compteRepository = new JdbcBasedCompteRepository();
        client = new Client();
        String num = "";
        num = displayCompte.saisieNumCompte();
        cmp = new Compte();
        cmp = compteRepository.getCompteByNum(num);
        if(cmp != null)
        {
            int mnt = 0 ;
            mnt = displayCompte.saisieMontant();

            String num2 = "";
            num2 = displayCompte.saisieNumCompte2();
            Compte cmp2 = new Compte();
            cmp2 = compteRepository.getCompteByNum(num2);
            if(cmp2 != null)
            {
                compteRepository.virement(cmp, mnt, cmp2);
                System.out.println("OPERATION DE VIREMENT REUSSIE");
            }
            else
            {
                System.out.println("NUMERO DE COMPTE EST INCORRECTE !!!");
            }
        }
        else
        {
            System.out.println("NUMERO DE COMPTE EST INCORRECTE !!!");
        }
    }
}
