package gestion.banque.services;

import gestion.banque.domain.Employe;

public interface DisplayEmploye {
    public void listerInfos();
    public void infoClient();
    public void listerOperation();
    public Employe saisieEmploye();
}
