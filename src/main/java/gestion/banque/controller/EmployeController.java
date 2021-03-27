package gestion.banque.controller;

import gestion.banque.services.ConsoleDisplayEmploye;
import gestion.banque.services.DisplayEmploye;
import gestion.banque.services.MenuService;
import gestion.banque.services.ScannerMenuService;

public class EmployeController {
    DisplayEmploye displayEmploye ;
    MenuService menuService ;
    String ok = "";
    public void process() {
        menuService = new ScannerMenuService();
        do {
            menuService.afficherMenuEmploye();
            ok = menuService.choixMenuEmploye();
            menuService.afficherChoixEmploye(ok);
        } while (!ok.equals("q"));
    }

    public void connexion()
    {
        displayEmploye = new ConsoleDisplayEmploye();
        if(displayEmploye.connexion() == null )
        {
            System.out.println("Echec de la connexion");
        }
        else {
            System.out.println("Connexion reussie");
            process();
        }
    }
}
