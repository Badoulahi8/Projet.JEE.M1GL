package gestion.banque;

import gestion.banque.controller.ClientController;
import gestion.banque.controller.MenuController;

public class GestionBancaireApp {

    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.process();
    }
}
