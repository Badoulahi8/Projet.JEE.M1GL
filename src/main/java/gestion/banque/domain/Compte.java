package gestion.banque.domain;

import java.util.Date;

public class Compte {
    private String numeroCompte ;
    private double montantCompte ;
    private Client client ;
    private Date dateCreation ;

    public Compte() {
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getMontantCompte() {
        return montantCompte;
    }

    public void setMontantCompte(double montantCompte) {
        this.montantCompte = montantCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
