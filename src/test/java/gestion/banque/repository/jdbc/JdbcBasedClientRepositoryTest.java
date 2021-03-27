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

    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        jdbcBasedClientRepository = new JdbcBasedClientRepository();
    }

    @Test
    void getClient(){
        System.out.println("TEST LIST DES CLIENT");
        System.out.println("Dans la méthode get client");
        //Act
        List<Client> clients = jdbcBasedClientRepository.allClient();
        Client[] t_clients = clients.toArray(new Client[0]) ;
        //Assert
        assertEquals(5, t_clients.length, "le nombre de client doit être 5");
    }
}
