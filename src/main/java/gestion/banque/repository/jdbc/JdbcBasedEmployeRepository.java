package gestion.banque.repository.jdbc;

import gestion.banque.domain.Employe;
import gestion.banque.repository.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcBasedEmployeRepository implements EmployeRepository {
    DataSource jdbcBasedDataSourceRepository ;
    EmployeRepository employeRepository;
    Employe employe ;

    public JdbcBasedEmployeRepository() {
        jdbcBasedDataSourceRepository = new JDBCBasedDataSourceRepository();
    }

    @Override
    public Employe connection(String login, String password) {
        employeRepository = new JdbcBasedEmployeRepository();
        String query = "SELECT * FROM employes WHERE login = ? AND password = ?";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                employe = new Employe();
                employe.setIdEmploye(rs.getInt("idemploye"));
                employe.setNomEmploye(rs.getString("nomemploye"));
                employe.setNomEmploye(rs.getString("prenomemploye"));
                employe.setNomEmploye(rs.getString("login"));
                employe.setNomEmploye(rs.getString("password"));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return employe;
    }
}
