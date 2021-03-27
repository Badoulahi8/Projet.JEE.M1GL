package gestion.banque.services;

import gestion.banque.domain.Employe;

public interface DisplayEmploye {
    public void listerInfos();
    public void infoClient();
    public void listerOperation();
    public String saisielogin();
    public String saisiePassword();
    public Employe connexion();
}
