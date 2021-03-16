package gestion.banque.repository;

import gestion.banque.domain.Client;
import gestion.banque.domain.Compte;

import java.util.List;

public interface CompteRepository {
    public int addCompte(Client cli);
    public void detailCompte(Compte cmp) ;
    public List<Compte> allCompte();
    public Compte getCompteByNum(String numero);
    public void depot(Compte cmp, double montant);
    public void retrait(Compte cmp, double montant);
    public void virement(Compte cmp, double montant, Compte cmp2);
}
