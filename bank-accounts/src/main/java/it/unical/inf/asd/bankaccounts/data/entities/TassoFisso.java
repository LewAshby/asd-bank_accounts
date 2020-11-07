package it.unical.inf.asd.bankaccounts.data.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class TassoFisso extends Titolo {
}
