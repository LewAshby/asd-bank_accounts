package it.unical.inf.asd.bankaccounts.data.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TITOLO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TASSO")
public class Titolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Lob
    @Basic(optional = false)
    @Column(name = "DESCRIZIONE", length = 1024)
    private String descrizione;

    @Basic(optional = false)
    @Column(name = "EMITTENTE")
    private String emittente;

    @Basic(optional = false)
    @Column(name = "SCADENZA")
    private Date scadenza;

    @Basic(optional = false)
    @Column(name = "VALORE_NOMINALE")
    private Double valoreNominale;

    @OneToMany(mappedBy = "titolo", fetch = FetchType.LAZY)
    private List<Cedola> cedolas;

    @OneToMany(mappedBy = "titolo", fetch = FetchType.LAZY)
    private List<SaldoPerTitolo> saldoPerTitolos;

    @OneToMany(mappedBy = "titolo", fetch = FetchType.LAZY)
    private List<Movimento> movimentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Cedola> getCedolas() {
        return cedolas;
    }

    public void setCedolas(List<Cedola> cedolas) {
        this.cedolas = cedolas;
    }

    public List<SaldoPerTitolo> getSaldoPerTitolos() {
        return saldoPerTitolos;
    }

    public void setSaldoPerTitolos(List<SaldoPerTitolo> saldoPerTitolos) {
        this.saldoPerTitolos = saldoPerTitolos;
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Titolo titolo = (Titolo) o;
        return Objects.equals(id, titolo.id) &&
                Objects.equals(descrizione, titolo.descrizione) &&
                Objects.equals(emittente, titolo.emittente) &&
                Objects.equals(scadenza, titolo.scadenza) &&
                Objects.equals(valoreNominale, titolo.valoreNominale) &&
                Objects.equals(cedolas, titolo.cedolas) &&
                Objects.equals(saldoPerTitolos, titolo.saldoPerTitolos) &&
                Objects.equals(movimentos, titolo.movimentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descrizione, emittente, scadenza, valoreNominale, cedolas, saldoPerTitolos, movimentos);
    }
}
