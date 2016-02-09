package newpackage.EntityPackage;

import javax.persistence.*;

@Entity
public class OffertaTrasporto extends Offerta {
    private String cittàPartenza;
    private String tipologia;
    private int durata;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer trasID;


    public OffertaTrasporto(){super();}

    public Integer getTrasID() {
        return trasID;
    }

    public void setTrasID(Integer trasID) {
        this.trasID = trasID;
    }

    @Basic
    public String getCittàPartenza() {
        return cittàPartenza;
    }

    public void setCittàPartenza(String cittàPartenza) {
        this.cittàPartenza = cittàPartenza;
    }

    @Basic
    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    @Basic
    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

}
