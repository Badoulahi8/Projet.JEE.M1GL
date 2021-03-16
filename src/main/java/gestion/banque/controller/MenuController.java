package gestion.banque.controller;

import gestion.banque.repository.ClientRepository;
import gestion.banque.repository.jdbc.JdbcBasedClientRepository;
import gestion.banque.services.ConsoleDisplayClient;
import gestion.banque.services.DisplayClient;
import gestion.banque.services.ScannerMenuService;

public class MenuController {
    ScannerMenuService scannerMenuService ;
    String ok ;
    ClientRepository clientRepository = new JdbcBasedClientRepository();
    ClientController clientController = new ClientController();
    EmployeController employeController = new EmployeController();
    public void process() {
        scannerMenuService = new ScannerMenuService();
        scannerMenuService.afficherBienvenu();
        do {
            ok = "";
            scannerMenuService.afficherMenuPricipal();
            ok = scannerMenuService.choixMenuPrincipal();
            if(ok.equals("c")){
                employeController.process();
            }
            else if (ok.equals("o")) {
                clientController.process();
            }
            } while (!ok.equals("q"));
    }
}
