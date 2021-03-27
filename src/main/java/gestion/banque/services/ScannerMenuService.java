package gestion.banque.services;

import gestion.banque.domain.Employe;

import java.util.Scanner;

public class ScannerMenuService implements MenuService {

    private Scanner scanner = new Scanner(System.in) ;
    private DisplayClient displayClient;
    private DisplayEmploye displayEmploye;
    private String rep = "" ;
    @Override
    public void afficherBienvenu() {
        System.out.println("BIENVENU DANS VOTRE BANQUE");
    }

    @Override
    public void afficherMenuPricipal() {
        System.out.println("-------------INTERFACE CLIENT--------");
        System.out.println("1 : Se connecter (c)");
        System.out.println("2 : Effectuer une operation (o)");
        System.out.println("3 : Quitter (q)");
    }

    @Override
    public String choixMenuPrincipal() {
        do {
            System.out.println("Faites votre choix");
            rep = scanner.next().toLowerCase();
            switch (rep)
            {
                case "c":
                {
                    System.out.println("INTERFACE DE CONNECTION");
                }
                break ;
                case "o":
                {
                    System.out.println("INTERFACE CLIENTEL");
                }
                break ;
                case "q" :
                    System.out.println("Au revoir");
                    break;
                default :
                    System.out.println("Choix non disponible");
                    break ;
            }
        }while(!rep.equals("c") && !rep.equals("o") && !rep.equals("q")) ;
        return rep ;
    }

    @Override
    public void afficherMenuClient() {
        System.out.println("-------------INTERFACE CLIENT--------");
        System.out.println("1 : Consulter mon compte (i)");
        System.out.println("2 : Ouvrir un compte (c)");
        System.out.println("3 : Faire un depot (d)");
        System.out.println("4 : Ouvrir un retrait (r)");
        System.out.println("5 : Ouvrir un virement (v)");
        System.out.println("6 : Retour au menu principal (q)");
    }

    @Override
    public String choixMenuClient() {
        do {
            System.out.println("Faites votre choix");
            rep = scanner.next().toLowerCase();
            switch (rep)
            {
                case "i":
                {
                    System.out.println("Consulter informations compte");
                }
                break ;
                case "c":
                {
                    System.out.println("Inscription");
                }
                break ;
                case "d" : {
                    System.out.println("Operation de depot");
                }
                break;
                case "r" :
                    System.out.println("Operation de retrait");
                    break;
                case "v" :
                    System.out.println("Operation de virement");
                    break;
                case "q" :
                    System.out.println("Au revoir");
                    break;
                default :
                    System.out.println("Choix non disponible");
                    break ;
            }
        }while(!rep.equals("c") && !rep.equals("i") && !rep.equals("d") &&
                !rep.equals("r") && !rep.equals("v") && !rep.equals("q")) ;
        return rep ;
    }

    @Override
    public void afficherChoixClient(String choix) {
        displayClient = new ConsoleDisplayClient();
        switch (choix)
        {
            case "i" :
            {
                displayClient.consulterCompte();
            }
            break ;
            case "c" :
            {
                displayClient.inscrire();
            }
            break ;
            case "d":
            {
                displayClient.depot();
            }
            break ;
            case "r" : {
                displayClient.retrait();
            }
            break;
            case "v" :
                displayClient.virement();
                break;
            case "q" :
                System.out.println("Au revoir");
                break;
            default :
                System.out.println("Choix non disponible");
                break ;
        }
    }

    @Override
    public String choixMenuEmploye() {
        do {
            System.out.println("Faites votre choix");
            rep = scanner.next().toLowerCase();
            switch (rep)
            {
                case "l":
                {
                    System.out.println("Lister les informations des clients");
                }
                break ;
                case "c":
                {
                    System.out.println("Lister les information d'un client");
                }
                break ;
                case "o" : {
                    System.out.println("Lister les operations des clients");
                }
                break;
                case "q" :
                    System.out.println("Au revoir");
                    break;
                default :
                    System.out.println("Choix non disponible");
                    break ;
            }
        }while(!rep.equals("l") && !rep.equals("c") && !rep.equals("o") && !rep.equals("q")) ;
        return rep ;
    }

    @Override
    public void afficherMenuEmploye() {
        System.out.println("-------------INTERFACE EMPLOYE --------");
        System.out.println("1 : Lister les informations des clients (l)");
        System.out.println("2 : Lister les information d'un client (c)");
        System.out.println("3 : Lister les operations des clients (o)");
        System.out.println("6 : Retour au menu principal (q)");
    }

    @Override
    public void afficherChoixEmploye(String choix) {
        displayClient = new ConsoleDisplayClient();
        displayEmploye = new ConsoleDisplayEmploye();
        switch (choix)
        {
            case "l" :
            {
                System.out.println("INFO");
                displayEmploye.listerInfos();
            }
            break ;
            case "c" :
            {
                System.out.println("CLIENT");
                displayEmploye.infoClient();
            }
            break ;
            case "o":
            {
                System.out.println("OPERATION");
            }
            break ;
            case "q" :
                System.out.println("");
                break;
            default :
                System.out.println("Choix non disponible");
                break ;
        }
    }
}
