package gestion.banque.repository.jdbc;

import gestion.banque.domain.Employe;

public interface EmployeRepository {
    public Employe connection(String login, String password);
}
