package it.unical.inf.asd.bankaccounts.data.dao;

import it.unical.inf.asd.bankaccounts.data.entities.Cedola;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CedolaDao extends CrudRepository<Cedola, Long> {

    List<Cedola> findAll();
}
