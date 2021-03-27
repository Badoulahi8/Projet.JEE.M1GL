package gestion.banque.repository.jdbc;

import gestion.banque.domain.Employe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcBasedEmployeRepositoryTest {
    private JdbcBasedEmployeRepository jdbcBasedEmployeRepository ;

    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        jdbcBasedEmployeRepository = new JdbcBasedEmployeRepository();
    }
    @Test
    void getEmploye()
    {
        System.out.println("TEST LIST DES COMPTE");
        System.out.println("Dans la méthode get compte");
        //Act
        List<Employe> employes = jdbcBasedEmployeRepository.allEmploye();
        Employe[] t_employe = employes.toArray(new Employe[0]) ;
        //Assert
        assertEquals(1, t_employe.length, "le nombre d'employe doit être 1");
    }
}
