package newpackage.EntityPackage;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Carrello implements Serializable{
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

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany//(fetch = FetchType.EAGER)
    public List<Pacchetto> getHasPacket() {
        return hasPacket;
    }

    public void setHasPacket(List<Pacchetto> hasPacket) {
        this.hasPacket = hasPacket;
    }

    private List<OffertaEvento> hasEvent;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany//(fetch = FetchType.EAGER)
    public List<OffertaEvento> getHasEvent() {
        return hasEvent;
    }

    public void setHasEvent(List<OffertaEvento> hasEvent) {
        this.hasEvent = hasEvent;
    }

    private List<OffertaTrasporto> hasTras;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany//(fetch = FetchType.EAGER)
    public List<OffertaTrasporto> getHasTras() {
        return hasTras;
    }

    public void setHasTras(List<OffertaTrasporto> hasTras) {
        this.hasTras = hasTras;
    }

    private List<OffertaPernotto> hasPer;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany//(fetch = FetchType.EAGER)
    public List<OffertaPernotto> getHasPer() {
        return hasPer;
    }

    public void setHasPer(List<OffertaPernotto> hasPer) {
        this.hasPer = hasPer;
    }

    public boolean addItemToCart(Object object){
        if(object instanceof Pacchetto){
            Pacchetto p = (Pacchetto) object;

            for(Pacchetto pacchetto : this.hasPacket){
                if(pacchetto.getId().equals(p.getId())){
                    return false;
                }
            }
            this.hasPacket.add(p);
            return true;
        }
        else if(object instanceof OffertaEvento){
            OffertaEvento oe = (OffertaEvento) object;

            for(OffertaEvento offertaEvento : this.hasEvent){
                if(offertaEvento.getEveID().equals(oe.getEveID())){
                    return false;
                }
            }

            this.hasEvent.add(oe);
            return true;
        }
        else if(object instanceof OffertaPernotto){
            OffertaPernotto op = (OffertaPernotto) object;

            for(OffertaPernotto offertaPernotto : this.hasPer){
                if(offertaPernotto.getPerID().equals(op.getPerID())){
                    return false;
                }
            }

            this.hasPer.add(op);
            return true;
        }
        else if(object instanceof OffertaTrasporto){
            OffertaTrasporto ot = (OffertaTrasporto) object;

            for(OffertaTrasporto offertaTrasporto : this.hasTras){
                if(offertaTrasporto.getTrasID().equals(ot.getTrasID())){
                    return false;
                }
            }

            this.hasTras.add(ot);
            return true;
        }
        return false;
    }

    public boolean removeItemFromCart(Object object){
        if(object instanceof Pacchetto){
            Pacchetto p = (Pacchetto) object;

            for(Pacchetto pacchetto : this.hasPacket){
                if(pacchetto.getId().equals(p.getId())){
                    return this.hasPacket.remove(pacchetto);
                }
            }

        }
        else if(object instanceof OffertaEvento){
            OffertaEvento oe = (OffertaEvento) object;
            for(OffertaEvento offertaEvento : this.hasEvent){
                if(offertaEvento.getEveID().equals(oe.getEveID())){
                    return this.hasEvent.remove(offertaEvento);
                }
            }
        }
        else if(object instanceof OffertaPernotto){
            OffertaPernotto op = (OffertaPernotto) object;
            for(OffertaPernotto offertaPernotto : this.hasPer){
                if(offertaPernotto.getPerID().equals(op.getPerID())){
                    return this.hasPer.remove(offertaPernotto);
                }
            }

        }
        else if(object instanceof OffertaTrasporto){
            OffertaTrasporto ot = (OffertaTrasporto) object;
            for(OffertaTrasporto offertaTrasporto : this.hasTras){
                if(offertaTrasporto.getTrasID().equals(ot.getTrasID())){
                    return this.hasTras.remove(offertaTrasporto);
                }
            }
        }
        return false;
    }

}
