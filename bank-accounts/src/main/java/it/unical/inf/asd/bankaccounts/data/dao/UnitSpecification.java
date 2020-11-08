package it.unical.inf.asd.bankaccounts.data.dao;

import it.unical.inf.asd.bankaccounts.data.entities.Titolo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UnitSpecification {

    public static class Filter {
        private String descrizione;
        private String emittente;
        private Date scadenza;
        private Double valoreNominale;

        public String getDescrizione() {
            return descrizione;
        }

        public void setDescrizione(String descrizione) {
            this.descrizione = descrizione;
        }

        public String getEmittente() {
            return emittente;
        }

        public void setEmittente(String emittente) {
            this.emittente = emittente;
        }

        public Date getScadenza() {
            return scadenza;
        }

        public void setScadenza(Date scadenza) {
            this.scadenza = scadenza;
        }

        public Double getValoreNominale() {
            return valoreNominale;
        }

        public void setValoreNominale(Double valoreNominale) {
            this.valoreNominale = valoreNominale;
        }
    }

    private UnitSpecification(){}

    public static Specification<Titolo> withFilter(Filter filter) {
        return (Specification<Titolo>) (root, criteriaQuery, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            if(filter.getEmittente()!=null)
                predicates.add(criteriaBuilder.equal(root.get("emittente"), filter.getEmittente()));
            if(filter.getScadenza()!=null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(filter.getScadenza());
                LocalDate date = LocalDate.now().minus(calendar.get(Calendar.YEAR), ChronoUnit.YEARS);
                predicates.add(criteriaBuilder.equal(root.get("scadenza"), date));
            }
            if(filter.getValoreNominale()!=null)
                predicates.add(criteriaBuilder.equal(root.get("valoreNominale"), filter.getValoreNominale()));
            if(filter.getDescrizione()!=null)
                predicates.add(criteriaBuilder.equal(root.get("descrizione"), filter.getDescrizione()));

            if(predicates.isEmpty())
                predicates.add(criteriaBuilder.equal(root.get("id"), -1L));

            return criteriaQuery.where(
                    criteriaBuilder.and(predicates.toArray(new Predicate[0])))
                    .distinct(true)
                    .orderBy(criteriaBuilder.desc(root.get("emittente")))
                    .getRestriction();
        };
    }
}
