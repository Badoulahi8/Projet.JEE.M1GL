package gestion.banque.services;

import gestion.banque.domain.Client;

public interface DisplayClient {
    public Client saisieClient();
    public void consulterCompte();
    public void inscrire();
    public void depot();
    public void retrait();
    public void virement();
}
