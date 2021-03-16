package gestion.banque.controller;

import gestion.banque.repository.ClientRepository;
import gestion.banque.repository.jdbc.JdbcBasedClientRepository;
import gestion.banque.services.ConsoleDisplayClient;
import gestion.banque.services.DisplayClient;
import gestion.banque.services.MenuService;
import gestion.banque.services.ScannerMenuService;

public class ClientController {
    DisplayClient displayClient ;
    MenuService menuService ;
    String ok = "";
    public void process(){
        menuService  = new ScannerMenuService();
        do {
            menuService.afficherMenuClient();
            ok = menuService.choixMenuClient();
            menuService.afficherChoixClient(ok);
        }while (!ok.equals("q"));

    }
}
