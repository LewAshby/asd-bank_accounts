package it.unical.inf.asd.bankaccounts.data.services;

import it.unical.inf.asd.bankaccounts.data.entities.Titolo;

import java.util.Date;
import java.util.List;

public interface TitoloService {

    List<Titolo> getAllTitolo();
    List<Titolo> getAllTitoloBeforeDate(Date date);
    List<Titolo> getAllByEmittente(String emittente);
}
