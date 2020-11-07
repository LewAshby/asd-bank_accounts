package it.unical.inf.asd.bankaccounts.data.services;

import it.unical.inf.asd.bankaccounts.data.dao.TitoloDao;
import it.unical.inf.asd.bankaccounts.data.entities.Titolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TitoloServiceImpl implements TitoloService{

    @Autowired
    private TitoloDao titoloDao;

    @Override
    public List<Titolo> getAllTitolo() {
        return titoloDao.findAll();
    }

    @Override
    public List<Titolo> getAllTitoloBeforeDate(Date date) {
        return titoloDao.findAllByScadenzaBefore(date);
    }

    @Override
    public List<Titolo> getAllByEmittente(String emittente) {
        return titoloDao.findAllByEmittente(emittente);
    }
}
