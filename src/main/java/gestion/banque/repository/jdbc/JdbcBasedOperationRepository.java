package gestion.banque.repository.jdbc;

import gestion.banque.domain.Operation;
import gestion.banque.repository.ClientRepository;
import gestion.banque.repository.DataSource;
import gestion.banque.repository.OperationRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcBasedOperationRepository implements OperationRepository {
    private DataSource jdbcBasedDataSourceRepository ;
    private ClientRepository clientRepository ;

    public JdbcBasedOperationRepository() {
        jdbcBasedDataSourceRepository = new JDBCBasedDataSourceRepository();
        clientRepository = new JdbcBasedClientRepository();
    }

    @Override
    public int addOperation(Operation op) {
        String query = "INSERT INTO operation VALUES (NULL,?,?,?)";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, op.getTypeOperation());
            statement.setString(2, op.getDateHeure());
            statement.setString(3, op.getClient().getNumeroClient());
            return statement.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Operation> allOperation() {

        String query = "SELECT * FROM operation";
        List<Operation> operations = new ArrayList<Operation>();
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                Operation op = new Operation();
                op.setIdOperation(rs.getInt("idoperation"));
                op.setTypeOperation(rs.getString("typeoperation"));
                op.setDateHeure(rs.getString("dateoperation"));
                op.setClient(clientRepository.getClientByNum(rs.getString("numeroclient")));
                operations.add(op);
            }
            return operations;
        }
        catch (SQLException e) {
            return null;
        }
        catch (Exception ex){
            return null;
        }
    }
}
