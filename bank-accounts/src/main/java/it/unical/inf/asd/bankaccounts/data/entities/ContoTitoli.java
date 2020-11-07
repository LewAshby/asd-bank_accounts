package it.unical.inf.asd.bankaccounts.data.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CONTO_TITOLI")
public class ContoTitoli {

    public enum TIPOCONTO {
        CORRENTE, ALTRA;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NUMERO_CONTO", unique = true, nullable = false)
    private Integer numeroConto;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_CONTO")
    private TIPOCONTO tipoConto;

    @OneToMany(mappedBy = "contoTitoli", fetch = FetchType.LAZY)
    private List<SaldoPerTitolo> saldoPerTitolos;

    @OneToMany(mappedBy = "contoTitoli", fetch = FetchType.LAZY)
    private List<Movimento> movimentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(Integer numeroConto) {
        this.numeroConto = numeroConto;
    }

    public TIPOCONTO getTipoConto() {
        return tipoConto;
    }

    public void setTipoConto(TIPOCONTO tipoConto) {
        this.tipoConto = tipoConto;
    }

    public List<SaldoPerTitolo> getSaldoPerTitolos() { return saldoPerTitolos; }

    public void setSaldoPerTitolos(List<SaldoPerTitolo> saldoPerTitolos) { this.saldoPerTitolos = saldoPerTitolos; }

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
        ContoTitoli that = (ContoTitoli) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(numeroConto, that.numeroConto) &&
                tipoConto == that.tipoConto &&
                Objects.equals(saldoPerTitolos, that.saldoPerTitolos) &&
                Objects.equals(movimentos, that.movimentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroConto, tipoConto, saldoPerTitolos, movimentos);
    }
}
