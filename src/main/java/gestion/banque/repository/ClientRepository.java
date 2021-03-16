package gestion.banque.repository;

import gestion.banque.domain.Client;

import java.util.List;

public interface ClientRepository {
    public int addClient(Client cli) ;
    public void detailClient(Client c) ;
    public int deleteClient(Client c) ;
    public int updateClient(Client c) ;
    public Client getClientByNum(String numero) ;
    public int getNewNum() ;
    public List<Client> allClient() ;
}
