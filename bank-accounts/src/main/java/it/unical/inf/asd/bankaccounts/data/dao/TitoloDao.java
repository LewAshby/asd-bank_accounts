package it.unical.inf.asd.bankaccounts.data.dao;

import it.unical.inf.asd.bankaccounts.data.entities.Titolo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TitoloDao extends CrudRepository<Titolo, Long>, JpaSpecificationExecutor<Titolo> {

    List<Titolo> findAll();
    List<Titolo> findAllByEmittente(String emittente);
    List<Titolo> findAllByScadenzaBefore(Date scadenza);
}
