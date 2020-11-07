package it.unical.inf.asd.bankaccounts.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SALDOPERTITOLO")
public class SaldoPerTitolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "QUANTITA")
    private Double quantita;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TITOLO_ID", referencedColumnName = "ID")
    private Titolo titolo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONTOTITOLO_ID", referencedColumnName = "ID")
    private ContoTitoli contoTitoli;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantita() {
        return quantita;
    }

    public void setQuantita(Double quantita) {
        this.quantita = quantita;
    }

    public Titolo getTitolo() {
        return titolo;
    }

    public void setTitolo(Titolo titolo) {
        this.titolo = titolo;
    }

    public ContoTitoli getContoTitoli() {
        return contoTitoli;
    }

    public void setContoTitoli(ContoTitoli contoTitoli) {
        this.contoTitoli = contoTitoli;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaldoPerTitolo that = (SaldoPerTitolo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(quantita, that.quantita) &&
                Objects.equals(titolo, that.titolo) &&
                Objects.equals(contoTitoli, that.contoTitoli);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantita, titolo, contoTitoli);
    }
}
