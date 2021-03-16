package gestion.banque.repository.jdbc;

import gestion.banque.domain.Client;
import gestion.banque.domain.Compte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcBasedClientRepositoryTest {
    private JdbcBasedClientRepository jdbcBasedClientRepository ;
    private JdbcBasedCompteRepository jdbcBasedCompteRepository ;

    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        jdbcBasedClientRepository = new JdbcBasedClientRepository();
        jdbcBasedCompteRepository = new JdbcBasedCompteRepository();
    }

    @Test
    void getClient(){
        System.out.println("TEST LIST DES CLIENT");
        System.out.println("Dans la méthode get client");
        //Act
        List<Client> clients = jdbcBasedClientRepository.allClient();
        Client[] t_clients = clients.toArray(new Client[0]) ;
        //Assert
        assertEquals(3, t_clients.length, "le nombre de client doit être 4");
    }

    @Test
    void getCompte()
    {
        System.out.println("TEST LIST DES COMPTE");
        System.out.println("Dans la méthode get compte");
        //Act
        List<Compte> comptes = jdbcBasedCompteRepository.allCompte();
        Compte[] t_compte = comptes.toArray(new Compte[0]) ;
        //Assert
        assertEquals(3, t_compte.length, "le nombre de compte doit être 3");
    }
}
