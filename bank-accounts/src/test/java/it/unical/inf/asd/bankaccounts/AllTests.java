package it.unical.inf.asd.bankaccounts;


import it.unical.inf.asd.bankaccounts.data.dao.TitoloDao;
import it.unical.inf.asd.bankaccounts.data.dao.UnitSpecification;
import it.unical.inf.asd.bankaccounts.data.entities.Titolo;
import it.unical.inf.asd.bankaccounts.data.services.TitoloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllTests {

    @Autowired
    private TitoloService titoloService;

    @Autowired
    private TitoloDao titoloDao;

    @Test
    public void getAllTitoloTest(){
        List<Titolo> titolos = titoloService.getAllTitolo();
        Assert.assertEquals(1, titolos.size());
    }

    @Test
    public void getAllTitoloByEmittenteTest() {
        List<Titolo> titolos = titoloService.getAllByEmittente("John Doe");
        Assert.assertEquals(1, titolos.size());
    }

    @Test
    public void getAllTitoloBeforeDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, 3);
        calendar.set(Calendar.DAY_OF_MONTH, 25);
        Date date = calendar.getTime();
        List<Titolo> titolos = titoloService.getAllTitoloBeforeDate(date);
        Assert.assertEquals(0, titolos.size());
    }

    @Test
    public void titoloSpecificationWithFilter(){
        UnitSpecification.Filter filter = new UnitSpecification.Filter();
        //filter.setEmittente("John Doe");
        //filter.setScadenza(new Date());
        filter.setDescrizione("una descripcion");
        filter.setValoreNominale(23.0);
        List<Titolo> titles = titoloDao.findAll(UnitSpecification.withFilter(filter));
        System.out.println("List size: " + titles.size());
        titoloDao.findAll(UnitSpecification.withFilter(filter)).stream().forEach(System.out::println);
    }
}
