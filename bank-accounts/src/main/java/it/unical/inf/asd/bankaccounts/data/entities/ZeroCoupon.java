package it.unical.inf.asd.bankaccounts.data.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Z")
public class ZeroCoupon extends Titolo {
}
