package gestion.banque.repository.jdbc;

import gestion.banque.domain.Client;
import gestion.banque.domain.Compte;
import gestion.banque.domain.Operation;
import gestion.banque.repository.ClientRepository;
import gestion.banque.repository.CompteRepository;
import gestion.banque.repository.DataSource;
import gestion.banque.repository.OperationRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcBasedCompteRepository implements CompteRepository {
    private DataSource jdbcBasedDataSourceRepository ;
    private OperationRepository operationRepository ;
    ClientRepository clientRepository ;
    CompteRepository compteRepository ;
    DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    Date date1 = new Date();
    private Compte cmp ;
    private Operation op ;

    public JdbcBasedCompteRepository() {
        jdbcBasedDataSourceRepository = new JDBCBasedDataSourceRepository();
        operationRepository = new JdbcBasedOperationRepository();
    }

    public int addCompte(Client cli) {
        clientRepository = new JdbcBasedClientRepository();
        String query = "INSERT INTO compte VALUES (NULL,?,?,?,?)";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "CMP-"+cli.getNumeroClient());
            statement.setDouble(2, 0.0);
            statement.setString(3, format.format(date));
            statement.setString(4, cli.getNumeroClient());
            return statement.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public void detailCompte(Compte cmp) {
        System.out.println("----------INFORMATION DU COMPTE----------------");
        System.out.println("NUMERO : "+cmp.getNumeroCompte());
        System.out.println("MONTANT : "+cmp.getMontantCompte());
    }

    public List<Compte> allCompte() {
        compteRepository = new JdbcBasedCompteRepository();
        clientRepository = new JdbcBasedClientRepository();
        List<Compte> comptes = new ArrayList<Compte>();
        String query = "SELECT * FROM compte" ;
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                cmp = new Compte();
                cmp.setMontantCompte(rs.getInt("montantcompte"));
                cmp.setNumeroCompte(rs.getString("numerocompte"));
                cmp.setClient(clientRepository.getClientByNum(rs.getString("numeroclient")));
                comptes.add(cmp);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return comptes;
    }

    public Compte getCompteByNum(String numero) {
        clientRepository = new JdbcBasedClientRepository();
        String query = "SELECT * FROM compte WHERE numerocompte = ?";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, numero);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                cmp = new Compte();
                cmp.setMontantCompte(rs.getInt("montantcompte"));
                cmp.setNumeroCompte(rs.getString("numerocompte"));
                cmp.setClient(clientRepository.getClientByNum(rs.getString("numeroclient")));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return cmp;
    }

    public void depot(Compte cmp, double montant) {
        cmp.setMontantCompte(cmp.getMontantCompte() + montant);
        String query = "UPDATE compte SET montantcompte = ? WHERE numerocompte = ?";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, cmp.getMontantCompte());
            statement.setString(2, cmp.getNumeroCompte());
            int ok = statement.executeUpdate();
            op = new Operation();
            op.setClient(cmp.getClient());
            op.setDateHeure(format1.format(date1));
            op.setTypeOperation("Depot");
            int okk = operationRepository.addOperation(op);
            if(ok != 0 && okk !=0)
            {
                System.out.println("Operaton de depot reusiie");
            }
            else
            {
                System.out.println("Depot non reussi");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void retrait(Compte cmp, double montant) {
        cmp.setMontantCompte(cmp.getMontantCompte() - montant);
        String query = "UPDATE compte SET montantcompte = ? WHERE numerocompte = ?";
        try {
            Connection connection = jdbcBasedDataSourceRepository.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, cmp.getMontantCompte());
            statement.setString(2, cmp.getNumeroCompte());
            int ok = statement.executeUpdate();
            op = new Operation();
            op.setClient(cmp.getClient());
            op.setDateHeure(format1.format(date1));
            op.setTypeOperation("Retraite");
            int okk = operationRepository.addOperation(op);
            if(ok != 0 && okk !=0)
            {
                System.out.println("Operaton de retraite reusie");
            }
            else
            {
                System.out.println("Retaite non reussi");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void virement(Compte cmp, double montant, Compte cmp2) {
        retrait(cmp, montant);
        depot(cmp2, montant);
    }
}
