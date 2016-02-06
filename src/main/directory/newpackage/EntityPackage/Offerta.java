package newpackage.EntityPackage;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;

/**
 * Created by Alessandro on 08/01/2016.
 */


//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class Offerta {
    private String ofID;
    private String nome;
    private int prezzo;
    private java.sql.Date dataScadenza;
    private String città;

//    @Id
//    public String getOfID() {
//        return ofID;
//    }
//
//    public void setOfID(String id) {
//        this.ofID = id;
//    }

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

}