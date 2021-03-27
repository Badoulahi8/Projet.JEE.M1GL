package gestion.banque.repository;

import gestion.banque.domain.Employe;

import java.util.List;

public interface EmployeRepository {
    public Employe connection(String login, String password);
    public List<Employe> allEmploye();
}
