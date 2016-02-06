package newpackage.EntityPackage;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Alessandro on 08/01/2016.
 */
@Entity
public class Pacchetto implements Serializable{
    private Integer id;
    private OffertaPernotto offertaPernotto;
    private OffertaTrasporto offertaTrasporto;
    private List<OffertaEvento> offertaEvento;
    private String nome;
    private Integer prezzo;
    private Boolean stato;

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    public OffertaPernotto getOffertaPernotto() {
        return offertaPernotto;
    }

    public void setOffertaPernotto(OffertaPernotto OffertaPernottoEntity) {
        this.offertaPernotto = OffertaPernottoEntity;
    }

    @ManyToOne
    public OffertaTrasporto getOffertaTrasporto() {
        return offertaTrasporto;
    }

    public void setOffertaTrasporto(OffertaTrasporto OffertaTrasportoEntity) {
        this.offertaTrasporto = OffertaTrasportoEntity;
    }
    //FetchType.EAGER
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany//(fetch = FetchType.EAGER)
    public List<OffertaEvento> getOffertaEvento() {
        return offertaEvento;
    }

    public void setOffertaEvento(List<OffertaEvento> OffertaEventoEntity) {
        this.offertaEvento = OffertaEventoEntity;
    }

    @Basic
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    public Integer getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }

    @Basic
    public Boolean getStato() {
        return stato;
    }

    public void setStato(Boolean stato) {
        this.stato = stato;
    }
}