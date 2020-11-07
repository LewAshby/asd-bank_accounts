package it.unical.inf.asd.bankaccounts.data.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "CEDOLA")
public class Cedola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PROGRESSIVO_CEDOLA", nullable = false, unique = true)
    private Integer progressivoCedola;

    @Column(name = "SCADENZA")
    private Date scadenza;

    @Column(name = "VALORE")
    private Double valore;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TITOLO_ID", referencedColumnName = "ID")
    private Titolo titolo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProgressivoCedola() {
        return progressivoCedola;
    }

    public void setProgressivoCedola(Integer progressivoCedola) {
        this.progressivoCedola = progressivoCedola;
    }

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public Double getValore() {
        return valore;
    }

    public void setValore(Double valore) {
        this.valore = valore;
    }

    public Titolo getTitolo() {
        return titolo;
    }

    public void setTitolo(Titolo titolo) {
        this.titolo = titolo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cedola cedola = (Cedola) o;
        return Objects.equals(id, cedola.id) &&
                Objects.equals(progressivoCedola, cedola.progressivoCedola) &&
                Objects.equals(scadenza, cedola.scadenza) &&
                Objects.equals(valore, cedola.valore) &&
                Objects.equals(titolo, cedola.titolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, progressivoCedola, scadenza, valore, titolo);
    }
}
