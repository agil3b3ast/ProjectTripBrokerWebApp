package newpackage.EntityPackage;

import javax.persistence.*;

@Entity
public class OffertaPernotto extends Offerta {
    private Integer numeroNotti;
    private String tipologia;
    private Integer stelle;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer perID;

    public OffertaPernotto(){super();}

    public Integer getPerID() {
        return perID;
    }

    public void setPerID(Integer id) {
        this.perID = id;
    }

    @Basic
    public Integer getNumeroNotti() {
        return numeroNotti;
    }

    public void setNumeroNotti(Integer numeroNotti) {
        this.numeroNotti = numeroNotti;
    }

    @Basic
    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    @Basic
    public Integer getStelle() {
        return stelle;
    }

    public void setStelle(Integer stelle) {
        this.stelle = stelle;
    }

}