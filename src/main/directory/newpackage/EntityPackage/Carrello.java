package newpackage.EntityPackage;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alessandro on 29/01/2016.
 */
@Entity
public class Carrello {
    private int id;

    @GeneratedValue
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private List<Pacchetto> hasPacket;

    @ManyToMany//(fetch = FetchType.EAGER)
    public List<Pacchetto> getHasPacket() {
        return hasPacket;
    }

    public void setHasPacket(List<Pacchetto> hasPacket) {
        this.hasPacket = hasPacket;
    }

    private List<OffertaEvento> hasEvent;

    @ManyToMany//(fetch = FetchType.EAGER)
    public List<OffertaEvento> getHasEvent() {
        return hasEvent;
    }

    public void setHasEvent(List<OffertaEvento> hasEvent) {
        this.hasEvent = hasEvent;
    }

    private List<OffertaTrasporto> hasTras;

    @ManyToMany//(fetch = FetchType.EAGER)
    public List<OffertaTrasporto> getHasTras() {
        return hasTras;
    }

    public void setHasTras(List<OffertaTrasporto> hasTras) {
        this.hasTras = hasTras;
    }

    private List<OffertaPernotto> hasPer;

    @ManyToMany//(fetch = FetchType.EAGER)
    public List<OffertaPernotto> getHasPer() {
        return hasPer;
    }

    public void setHasPer(List<OffertaPernotto> hasPer) {
        this.hasPer = hasPer;
    }
}
