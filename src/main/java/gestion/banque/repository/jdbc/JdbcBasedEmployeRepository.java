package gestion.banque.repository.jdbc;

import gestion.banque.domain.Employe;
import gestion.banque.repository.DataSource;
import gestion.banque.repository.EmployeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        String query = "SELECT * FROM employe WHERE login = ? AND password = ?";
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

    @Override
    public List<Employe> allEmploye() {
        String query = "SELECT * FROM employe";
        List<Employe> employes = new ArrayList<Employe>();
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;
            while (rs.next()) {
                Employe emp = new Employe();
                emp.setIdEmploye(rs.getInt("idemploye"));
                emp.setNomEmploye(rs.getString("nomemploye"));
                emp.setPrenomEmploye(rs.getString("prenomemploye"));
                emp.setLogin(rs.getString("login"));
                emp.setPassword(rs.getString("password"));
                employes.add(emp);
            }
            return employes;
        }
        catch (SQLException e) {
            return null;
        }
        catch (Exception ex) {
            return null;
        }
    }
}
