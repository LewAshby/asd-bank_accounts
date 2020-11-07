package it.unical.inf.asd.bankaccounts.data.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "MOVIMENTO")
public class Movimento {

    public enum TIPOMOV {
        LOCALE, EXTERNO;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Basic(optional = false)
    @Column(name = "DATE")
    private Date date;

    @Basic(optional = false)
    @Column(name = "PROGRESSIVO")
    private Integer progressivo;

    @Basic(optional = false)
    @Column(name = "QUANTITA")
    private Double quantita;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPOMOVIMENTO")
    private TIPOMOV tipomovimento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TITOLO_ID", referencedColumnName = "ID")
    private Titolo titolo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONTOTITOLI_ID", referencedColumnName = "ID")
    private ContoTitoli contoTitoli;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getProgressivo() {
        return progressivo;
    }

    public void setProgressivo(Integer progressivo) {
        this.progressivo = progressivo;
    }

    public Double getQuantita() {
        return quantita;
    }

    public void setQuantita(Double quantita) {
        this.quantita = quantita;
    }

    public TIPOMOV getTipomovimento() {
        return tipomovimento;
    }

    public void setTipomovimento(TIPOMOV tipomovimento) {
        this.tipomovimento = tipomovimento;
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
        Movimento movimento = (Movimento) o;
        return Objects.equals(id, movimento.id) &&
                Objects.equals(date, movimento.date) &&
                Objects.equals(progressivo, movimento.progressivo) &&
                Objects.equals(quantita, movimento.quantita) &&
                tipomovimento == movimento.tipomovimento &&
                Objects.equals(titolo, movimento.titolo) &&
                Objects.equals(contoTitoli, movimento.contoTitoli);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, progressivo, quantita, tipomovimento, titolo, contoTitoli);
    }
}
