package newpackage;

import newpackage.EntityPackage.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alessandro on 10/01/2016.
 */

public class CarrelloBean implements Serializable{
    //private ArrayList<Pacchetto> packetlist;
    //private ArrayList<OffertaEvento> offertaEventoArrayList;
    //private ArrayList<OffertaPernotto> offertaPernottoArrayList;
    //private ArrayList<OffertaTrasporto> offertaTrasportoArrayList;
    private int idcart;
    private ArrayList<Object> itemList;
    private String packetitem;
    private String offereventoitem;
    private String offerpernottoitem;
    private String offertrasportoitem;

    private UtenteBean utenteBean;

    public CarrelloBean(){
        this.packetitem = "";
        this.offereventoitem = "";
        this.offerpernottoitem = "";
        this.offertrasportoitem = "";
        this.itemList = new ArrayList<Object>();
        this.utenteBean = null;
        //this.offertaTrasportoArrayList = new ArrayList<OffertaTrasporto>();
        //this.offertaPernottoArrayList = new ArrayList<OffertaPernotto>();
        //this.offertaEventoArrayList = new ArrayList<OffertaEvento>();
        //this.packetlist = new ArrayList<Pacchetto>();
    }

    public CarrelloBean(Carrello carrello){
        this.idcart = carrello.getId();
        this.packetitem = "";
        this.offereventoitem = "";
        this.offerpernottoitem = "";
        this.offertrasportoitem = "";
        this.itemList = new ArrayList<Object>();
        this.utenteBean = null;

        for(Object o: carrello.getHasEvent()){
            this.itemList.add(fromObjtoBean(o));
        }


        for(Object o: carrello.getHasPacket()){
            this.itemList.add(fromObjtoBean(o));
        }

        for(Object o: carrello.getHasPer()){
            this.itemList.add(fromObjtoBean(o));
        }

        for(Object o: carrello.getHasTras()){
            this.itemList.add(fromObjtoBean(o));
        }
    }


    public UtenteBean getUtenteBean() {
        return utenteBean;
    }

    public void setUtenteBean(UtenteBean utenteBean) {
        this.utenteBean = utenteBean;
    }

    public ArrayList<Object> getItemList(){return this.itemList;}
    public void setItemList(ArrayList<Object> newitemlist){this.itemList = newitemlist;}
    //public ArrayList<Pacchetto> getPacketlist(){return this.packetlist;}
    //public ArrayList<OffertaEvento> getOfferEventolist(){return this.offertaEventoArrayList;}
    //public ArrayList<OffertaPernotto> getOfferPernottoArrayList(){return this.offertaPernottoArrayList;}
    //public ArrayList<OffertaTrasporto> getOffertaTrasportoArrayList(){return this.offertaTrasportoArrayList;}
    public String getPacketitem(){return this.packetitem;}
    public String getOffereventoitem(){return this.offereventoitem;}
    public void setOffereventoitem(String newofferitem){this.offereventoitem = newofferitem;}
    public String getOfferpernottoitem(){return this.offerpernottoitem;}
    public void setOfferpernottoitem(String newofferitem){this.offerpernottoitem = newofferitem;}
    public String getOffertrasportoitem(){return this.offertrasportoitem;}
    public void setOffertrasportoitem(String newofferitem){this.offertrasportoitem = newofferitem;}
    public void setPacketitem(String newpacketitem){this.packetitem = newpacketitem;}


    public boolean carrelloempty(){
        //return (this.getOffertaTrasportoArrayList().isEmpty() && this.getOfferPernottoArrayList().isEmpty() && this.getOfferEventolist().isEmpty() && this.getPacketlist().isEmpty());
        return this.itemList.isEmpty();
    }

    public boolean removeItemFromCart(Object o){
        Object res = fromObjtoBean(o);
        if(res instanceof PacchettoBean){

            for(Object obj:this.itemList){
                if(obj instanceof PacchettoBean){
                    if(((PacchettoBean) obj).getId() == ((PacchettoBean) res).getId())
                        return this.itemList.remove(obj);
                }
            }
        }
        if(res instanceof OffertaEventoBean){
            for(Object obj:this.itemList){
                if(obj instanceof OffertaEventoBean){
                    if(((OffertaEventoBean) obj).getOfid() == ((OffertaEventoBean) res).getOfid())
                        return this.itemList.remove(obj);
                }
            }
        }
        if(res instanceof OffertaPernottoBean){

            for(Object obj:this.itemList){
                if(obj instanceof OffertaPernottoBean){
                    if(((OffertaPernottoBean) obj).getOfid() == ((OffertaPernottoBean) res).getOfid())
                        return this.itemList.remove(obj);
                }
            }
        }
        if(res instanceof OffertaTrasportoBean){

            for(Object obj:this.itemList){
                if(obj instanceof OffertaTrasportoBean){
                    if(((OffertaTrasportoBean) obj).getOfid() == ((OffertaTrasportoBean) res).getOfid())
                        return this.itemList.remove(obj);
                }
            }
        }

        return false;
    }


    public Object fromObjtoBean(Object object){

        if(object instanceof OffertaEvento){
            OffertaEventoBean returnobject = new OffertaEventoBean();
            OffertaEvento ofEve = (OffertaEvento) object;

            returnobject.setOfdateexpired(ofEve.getDataScadenza().toString());
            returnobject.setOfname(ofEve.getNome());
            returnobject.setOftype(ofEve.getTipologia());
            returnobject.setOfprice(ofEve.getPrezzo());
            returnobject.setOfid(ofEve.getEveID());
            returnobject.setOfcity(ofEve.getCittà());

            return returnobject;
        }

        if(object instanceof OffertaTrasporto){
            OffertaTrasportoBean returnobject = new OffertaTrasportoBean();
            OffertaTrasporto ofTras = (OffertaTrasporto) object;
            returnobject.setOfdateexpired(ofTras.getDataScadenza().toString());
            returnobject.setOfname(ofTras.getNome());
            returnobject.setOftype(ofTras.getTipologia());
            returnobject.setOfprice(ofTras.getPrezzo());
            returnobject.setOfid(ofTras.getTrasID());
            returnobject.setCityFrom(ofTras.getCittàPartenza());
            returnobject.setDuration(String.valueOf(ofTras.getDurata()));
            returnobject.setOfcity(ofTras.getCittà());

            return returnobject;
        }

        if(object instanceof OffertaPernotto){
            OffertaPernottoBean returnobject = new OffertaPernottoBean();
            OffertaPernotto ofPern = (OffertaPernotto) object;

            returnobject.setOfdateexpired(ofPern.getDataScadenza().toString());
            returnobject.setOfname(ofPern.getNome());
            returnobject.setOftype(ofPern.getTipologia());
            returnobject.setOfprice(ofPern.getPrezzo());
            returnobject.setOfid(ofPern.getPerID());
            returnobject.setNumberOfNights(String.valueOf(ofPern.getNumeroNotti()));
            returnobject.setStars(String.valueOf(ofPern.getStelle()));
            returnobject.setOfcity(ofPern.getCittà());

            return returnobject;
        }

        if(object instanceof Pacchetto){
            Pacchetto p = (Pacchetto) object;
            PacchettoBean pbean = new PacchettoBean();

            pbean.setPname(p.getNome());
            pbean.setPprice(p.getPrezzo());
            pbean.setPofpernotto(p.getOffertaPernotto());
            pbean.setPoftrasporto(p.getOffertaTrasporto());
            pbean.setPofevento(p.getOffertaEvento());
            pbean.setId(p.getId());

            return pbean;
        }
        return null;
    }

    public boolean removeItem() {

        if (!this.packetitem.equals("")) {
            //PacchettoController pc = PacchettoController.getInstance();
            //Pacchetto p = pc.findByID(this.packetitem);
            GestioneCarrelloController gc = GestioneCarrelloController.getInstance();
            Object o = gc.removeItem(this.packetitem, "Pacchetto", String.valueOf(this.idcart));

            if (o != null) {
                Pacchetto p = (Pacchetto) o;
                //for(Pacchetto pack : this.packetlist){
                /*for(Object object : this.itemList){
                    //if(pack.getId().equals(p.getId())){
                    if(object instanceof PacchettoBean){
                        if(((PacchettoBean)object).getId() ==  p.getId()) {
                            this.packetitem = "";
                            return false;
                        }
                    }
                }*/
                this.packetitem = "";
                return removeItemFromCart(p);
            }
            return false;

        } else if (!this.offereventoitem.equals("")) {
            GestioneCarrelloController gc = GestioneCarrelloController.getInstance();
            Object o = gc.removeItem(this.offereventoitem, "OffertaEvento", String.valueOf(this.idcart));

            if (o != null) {
                OffertaEvento oe = (OffertaEvento) o;

                this.offereventoitem = "";
                return removeItemFromCart(oe);

            }
            return false;


        } else if (!this.offerpernottoitem.equals("")) {
            GestioneCarrelloController gc = GestioneCarrelloController.getInstance();
            Object o = gc.removeItem(this.offerpernottoitem, "OffertaPernotto", String.valueOf(this.idcart));

            if (o != null) {
                OffertaPernotto op = (OffertaPernotto) o;

                this.offerpernottoitem = "";
                return removeItemFromCart(op);

            }
            return false;


        } else if (!this.offertrasportoitem.equals("")) {
            GestioneCarrelloController gc = GestioneCarrelloController.getInstance();
            Object o = gc.removeItem(this.offertrasportoitem, "OffertaTrasporto", String.valueOf(this.idcart));

            if (o != null) {
                OffertaTrasporto ot = (OffertaTrasporto) o;

                this.offertrasportoitem = "";
                return removeItemFromCart(ot);
            }
            return false;
        }
        return false;
    }

    public boolean addItem() {

        if (!this.packetitem.equals("")) {
            //PacchettoController pc = PacchettoController.getInstance();
            //Pacchetto p = pc.findByID(this.packetitem);
            GestioneCarrelloController gc = GestioneCarrelloController.getInstance();
            Object o = gc.addItem(this.packetitem,"Pacchetto",String.valueOf(this.idcart));

            if (o != null) {
                Pacchetto p = (Pacchetto) o;
                //for(Pacchetto pack : this.packetlist){
                /*for(Object object : this.itemList){
                    //if(pack.getId().equals(p.getId())){
                    if(object instanceof PacchettoBean){
                        if(((PacchettoBean)object).getId() ==  p.getId()) {
                            this.packetitem = "";
                            return false;
                        }
                    }
                }*/
                this.itemList.add(fromObjtoBean(p));
                this.packetitem = "";
                return true;
            }
            return false;
        }

        else if(!this.offereventoitem.equals("")){
            GestioneCarrelloController gc = GestioneCarrelloController.getInstance();
            Object o = gc.addItem(this.offereventoitem,"OffertaEvento",String.valueOf(this.idcart));

            if (o != null) {
                OffertaEvento oe = (OffertaEvento) o;

                this.itemList.add(fromObjtoBean(oe));
                this.offereventoitem = "";
                return true;
            }
            return false;


        }

        else if(!this.offerpernottoitem.equals("")){
            GestioneCarrelloController gc = GestioneCarrelloController.getInstance();
            Object o = gc.addItem(this.offerpernottoitem,"OffertaPernotto",String.valueOf(this.idcart));

            if (o != null) {
                OffertaPernotto op = (OffertaPernotto) o;

                this.itemList.add(fromObjtoBean(op));
                this.offerpernottoitem = "";
                return true;
            }
            return false;


        }

        else if(!this.offertrasportoitem.equals("")){
            GestioneCarrelloController gc = GestioneCarrelloController.getInstance();
            Object o = gc.addItem(this.offertrasportoitem,"OffertaTrasporto",String.valueOf(this.idcart));

            if (o != null) {
                OffertaTrasporto ot = (OffertaTrasporto) o;

                this.itemList.add(fromObjtoBean(ot));
                this.offertrasportoitem = "";
                return true;
            }
            return false;
        }



        /*
        if (!this.offereventoitem.equals("") || !this.offertrasportoitem.equals("") || !this.offerpernottoitem.equals("")) {

            OffertaController oc = OffertaController.getInstance();

            if(!this.offereventoitem.equals("")) {
                Object of = oc.findByID(TipoOfferta.OffertaEvento, this.offereventoitem);

                if (of != null) {
                    for(Object object : this.itemList){
                    //for(OffertaEvento ofev : this.offertaEventoArrayList){
                        //if(ofev.getEveID().equals(((OffertaEvento)of).getEveID())){
                        if(object instanceof OffertaEventoBean){
                            if(((OffertaEventoBean)object).getOfid() == ((OffertaEvento)of).getEveID()) {
                                this.offereventoitem = "";
                                return false;
                            }
                        }
                    }
                    //this.offertaEventoArrayList.add((OffertaEvento) of);
                    this.itemList.add(fromObjtoBean(of));
                    this.offereventoitem = "";
                    return true;
                }
            }

            if(!this.offerpernottoitem.equals("")) {
                Object of = oc.findByID(TipoOfferta.OffertaPernotto, this.offerpernottoitem);
                if (of != null) {
                    for(Object object : this.itemList){
                    //for(OffertaPernotto ofper: this.offertaPernottoArrayList){
                        //if(ofper.getPerID().equals(((OffertaPernotto)of).getPerID())){
                        if(object instanceof OffertaPernottoBean){
                            if(((OffertaPernottoBean)object).getOfid() == ((OffertaPernotto)of).getPerID()) {
                                this.offerpernottoitem = "";
                                return false;
                            }
                        }
                    }
                    //this.offertaPernottoArrayList.add((OffertaPernotto) of);
                    this.itemList.add(fromObjtoBean(of));
                    this.offerpernottoitem = "";
                    return true;
                }
            }

            if(!this.offertrasportoitem.equals("")) {
                Object of = oc.findByID(TipoOfferta.OffertaTrasporto, this.offertrasportoitem);
                if (of != null) {
                    for(Object object : this.itemList){
                    //for(OffertaTrasporto oftr : this.offertaTrasportoArrayList){
                    //    if(oftr.getTrasID().equals(((OffertaTrasporto)of).getTrasID())){
                        if(object instanceof OffertaTrasportoBean){
                            if(((OffertaTrasportoBean) object).getOfid() == ((OffertaTrasporto) of).getTrasID()) {
                                this.offertrasportoitem = "";
                                return false;
                            }
                        }
                    }
                    //this.offertaTrasportoArrayList.add((OffertaTrasporto) of);
                    this.itemList.add(fromObjtoBean(of));
                    this.offertrasportoitem = "";
                    return true;
                }
            }
        }*/
        return false;
    }

    public Object Pay(){
        PagamentoController pc = PagamentoController.getInstance();
        Object o = pc.Pay(this.itemList,idcart);
        if(o == null)
        {
            this.itemList.clear();
            return null;
        }
        return o;
        //pc.Pay(this.packetlist,this.offertaEventoArrayList,this.offertaPernottoArrayList,this.offertaTrasportoArrayList);

        //return this.packetlist.isEmpty() && this.offertaEventoArrayList.isEmpty() && this.offertaTrasportoArrayList.isEmpty() && this.offertaPernottoArrayList.isEmpty();
        //return false;
    }

    public int getIdcart() {
        return idcart;
    }

    public void setIdcart(int idcart) {
        this.idcart = idcart;
    }
}
