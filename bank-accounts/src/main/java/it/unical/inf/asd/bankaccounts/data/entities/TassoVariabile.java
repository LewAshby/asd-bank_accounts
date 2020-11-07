package it.unical.inf.asd.bankaccounts.data.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class TassoVariabile extends Titolo {

    @Column(name = "SPREAD")
    private Double spread;

    public Double getSpread() {
        return spread;
    }

    public void setSpread(Double spread) {
        this.spread = spread;
    }
}
