package it.unical.inf.asd.bankaccounts.data.dao;

import it.unical.inf.asd.bankaccounts.data.entities.Movimento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentoDao extends CrudRepository<Movimento, Long> {

    List<Movimento> findAllByTipomovimento(String tipoMov);
}
