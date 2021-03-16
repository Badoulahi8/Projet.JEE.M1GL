package gestion.banque.repository.jdbc;

import gestion.banque.domain.Client;
import gestion.banque.repository.ClientRepository;
import gestion.banque.repository.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcBasedClientRepository implements ClientRepository {
    ClientRepository clientRepository;
    private int ok = 0 ;
    private Client cl = null ;
    DataSource jdbcBasedDataSourceRepository;

    public JdbcBasedClientRepository() {
        jdbcBasedDataSourceRepository = new JDBCBasedDataSourceRepository();
    }

    public int addClient(Client cli) {
        clientRepository = new JdbcBasedClientRepository();
        String query = "INSERT INTO client VALUES (NULL,?,?,?,?)";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cli.getNumeroClient());
            statement.setString(2, cli.getNomClient());
            statement.setString(3, cli.getAdresseClient());
            statement.setString(4, cli.getTelephoneClient());
            ok = statement.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    public void detailClient(Client c) {
        System.out.println("----------INFORMATION DU CLIENT----------------");
        System.out.println("ID : "+c.getIdClient());
        System.out.println("NOM : "+c.getNomClient());
        System.out.println("ADRESSE : "+c.getAdresseClient());
        System.out.println("TELEPHONE : "+c.getTelephoneClient());
    }

    public int deleteClient(Client c) {
        String query = "DELETE FROM client where idclient = ?";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, c.getIdClient());
            ok = statement.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    public int updateClient(Client c) {
        String query = "UPDATE client SET nomclient = ?, adresseclient = ?, telephoneclient = ? where idclient = ?";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, c.getNomClient());
            statement.setString(2, c.getAdresseClient());
            statement.setString(3, c.getTelephoneClient());
            statement.setInt(4, c.getIdClient());
            ok = statement.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    public Client getClientByNum(String numero) {
        String query = "SELECT * FROM client WHERE numeroclient = ?";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numero);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                cl = new Client();
                cl.setIdClient(rs.getInt("idclient"));
                cl.setNomClient(rs.getString("nomclient"));
                cl.setAdresseClient(rs.getString("adresseclient"));
                cl.setTelephoneClient(rs.getString("telephoneclient"));
                cl.setNumeroClient(rs.getString("numeroclient"));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return cl;
    }

    @Override
    public int getNewNum() {
        return allClient().toArray(new Client[0]).length;
    }

    public List<Client> allClient() {
        String query = "SELECT * FROM client";
        List<Client> clients = new ArrayList<Client>();
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                Client cl = new Client();
                cl.setIdClient(rs.getInt("idclient"));
                cl.setNomClient(rs.getString("nomclient"));
                cl.setAdresseClient(rs.getString("adresseclient"));
                cl.setTelephoneClient(rs.getString("telephoneclient"));
                clients.add(cl);
            }
            return clients;
        }
        catch (SQLException e) {
            return null;
        }
        catch (Exception ex){
            return null;
        }
    }
}
