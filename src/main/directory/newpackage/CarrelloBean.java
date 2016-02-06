package newpackage;

import newpackage.EntityPackage.OffertaEvento;
import newpackage.EntityPackage.OffertaPernotto;
import newpackage.EntityPackage.OffertaTrasporto;
import newpackage.EntityPackage.Pacchetto;

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

    public boolean addItem() {

        if (!this.packetitem.equals("")) {
            PacchettoController pc = PacchettoController.getInstance();
            Pacchetto p = pc.findByID(this.packetitem);
            if (p != null) {
                //for(Pacchetto pack : this.packetlist){
                for(Object object : this.itemList){
                    //if(pack.getId().equals(p.getId())){
                    if(object instanceof PacchettoBean){
                        if(((PacchettoBean)object).getId() ==  p.getId()) {
                            this.packetitem = "";
                            return false;
                        }
                    }
                }
                this.itemList.add(fromObjtoBean(p));
                //this.packetlist.add(p);
                this.packetitem = "";
                return true;
            }
            return false;
        }

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
        }
        return false;
    }

    public boolean Pay(){
        PagamentoController pc = PagamentoController.getInstance();
        //pc.Pay(this.packetlist,this.offertaEventoArrayList,this.offertaPernottoArrayList,this.offertaTrasportoArrayList);

        //return this.packetlist.isEmpty() && this.offertaEventoArrayList.isEmpty() && this.offertaTrasportoArrayList.isEmpty() && this.offertaPernottoArrayList.isEmpty();
        return false;
    }

}
