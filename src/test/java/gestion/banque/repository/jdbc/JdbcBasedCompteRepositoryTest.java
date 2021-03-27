package gestion.banque.repository.jdbc;

import gestion.banque.domain.Compte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcBasedCompteRepositoryTest {
    private JdbcBasedCompteRepository jdbcBasedCompteRepository ;

    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        jdbcBasedCompteRepository = new JdbcBasedCompteRepository();
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
        assertEquals(5, t_compte.length, "le nombre de compte doit être 5");
    }
}
