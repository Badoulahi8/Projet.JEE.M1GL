package gestion.banque.repository;

import gestion.banque.domain.Operation;

import java.util.List;

public interface OperationRepository {
    public int addOperation(Operation op);
    public List<Operation> allOperation();
}
