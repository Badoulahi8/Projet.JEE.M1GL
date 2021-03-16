package gestion.banque.repository;

import java.sql.Connection;

public interface DataSource {
    public Connection createConnection();
}
