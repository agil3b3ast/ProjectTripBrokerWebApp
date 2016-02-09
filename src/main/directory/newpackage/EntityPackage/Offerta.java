package newpackage.EntityPackage;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@MappedSuperclass
public class Offerta implements Serializable{
    private String ofID;
    private String nome;
    private int prezzo;
    private java.sql.Date dataScadenza;
    private String città;

    public Offerta(){super();}

    @Basic
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    @Basic
    public java.sql.Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(java.sql.Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    @Basic
    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    private boolean toBuy;

    @Basic
    public boolean isToBuy() {
        return toBuy;
    }

    public void setToBuy(boolean toBuy) {
        this.toBuy = toBuy;
    }
}