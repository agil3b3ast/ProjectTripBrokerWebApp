package newpackage.EntityPackage;

import javax.persistence.*;

@Entity
public class OffertaEvento extends Offerta {
    private String tipologia;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer eveID;

    public OffertaEvento(){super();}

    public Integer getEveID() {
        return eveID;
    }

    public void setEveID(Integer eveID) {
        this.eveID = eveID;
    }

    @Basic
    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

}
