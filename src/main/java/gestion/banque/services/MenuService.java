package gestion.banque.services;

import gestion.banque.domain.Employe;

public interface MenuService {
    public void afficherBienvenu();
    public void afficherMenuPricipal();
    public String choixMenuPrincipal();

    public String choixMenuClient();
    public void afficherMenuClient();
    public void afficherChoixClient(String choix);

    public String choixMenuEmploye();
    public void afficherMenuEmploye();
    public void afficherChoixEmploye(String choix);
}
