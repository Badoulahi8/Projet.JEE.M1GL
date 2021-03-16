package gestion.banque.services;

import java.util.Scanner;

public class ConsoleDisplayCompte implements DisplayCompte {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String saisieNumCompte() {
        String numero= "";
        do {
            System.out.println("Donner le numero de votre compte");
            numero = scanner.next();
        }while(numero.equals(""));
        return numero ;
    }

    @Override
    public String saisieNumCompte2() {
        String numero= "";
        do {
            System.out.println("Donner le numero du compte de destinantaire");
            numero = scanner.next();
        }while(numero.equals(""));
        return numero ;
    }

    @Override
    public int saisieMontant() {
        int montant= 0;
        do {
            System.out.println("Saisissez le montant");
            System.out.println("Le montant doit etre superieur a 0 !!! ");
            montant = scanner.nextInt();
        }while(montant == 0 || montant < 0);
        return montant ;
    }
}
