package newpackage;

/**
 * Created by Alessandro on 08/01/2016.
 */

import newpackage.EntityPackage.OffertaEvento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alessandro on 28/12/2015.
 */
public class OffertaEventoBean extends OffertaBean{
    private String oftype;
    private int ofid;

    public OffertaEventoBean(){
        super();
        this.oftype = "";
    }

    public String getOftype(){return this.oftype;}
    public void setOftype(String newoftype){this.oftype = newoftype;}
    public int getOfid(){return this.ofid;}
    public void setOfid(int newid){this.ofid = newid;}

    /*
    public boolean selectAll(){
        if(this.oftype != ""){
            this.oftype = "Concerto";
        }

        OffertaController controller = OffertaController.getInstance();

        ArrayList<Offerta> offlist = controller.findAll("offertaevento",this.oftype);
        OffertaBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (Offerta off : offlist) {

                offbean = new OffertaBean();
                offbean.setOfdateexpired(off.getOfdateexpired());
                offbean.setOfname(off.getOfname());
                offbean.setOftype(off.getOftype());
                offbean.setOfprice(off.getOfprice());

                this.offerList.add(offbean);

            }
        }
        return this.offerList == null;
    }*/
    @Override
    public boolean selectAll(){
        if(this.oftype == ""){
            //this.oftype = "Concerto";
            return false;
        }

        OffertaController controller = OffertaController.getInstance();

        List<OffertaEvento> offlist = (List<OffertaEvento>) controller.findAll(TipoOfferta.OffertaEvento,this.oftype);
        OffertaEventoBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (OffertaEvento off : offlist) {

                offbean = new OffertaEventoBean();
                offbean.setOfdateexpired(off.getDataScadenza().toString());
                offbean.setOfname(off.getNome());
                offbean.setOftype(off.getTipologia());
                offbean.setOfprice((off.getPrezzo()));
                offbean.setOfid(off.getEveID());
                offbean.setOfcity(off.getCittà());
                this.offerList.add(offbean);
            }
        }
        return this.offerList == null;
    }

    public List<String> toStringList(){
        List<String> ls = new ArrayList<String>();
        ls.add(getOfcity());
        ls.add(getOfdateexpired());
        ls.add(getOfname());
        if(getOfprice() > 0)
            ls.add(String.valueOf(getOfprice()));
        else
            ls.add("");
        ls.add(getOftype());
        return ls;
    }

    public ArrayList<OffertaBean> fromEvtoEvBean(List<OffertaEvento> offlist){
        OffertaEventoBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (OffertaEvento off : offlist) {

                offbean = new OffertaEventoBean();
                offbean.setOfdateexpired(off.getDataScadenza().toString());
                offbean.setOfname(off.getNome());
                offbean.setOftype(off.getTipologia());
                offbean.setOfprice((off.getPrezzo()));
                offbean.setOfid(off.getEveID());
                offbean.setOfcity(off.getCittà());
                this.offerList.add(offbean);
            }
        }

        return this.offerList;
    }


    public boolean fillToFind(){
        List<String> ls = this.toStringList();

        OffertaController controller = OffertaController.getInstance();
        List<OffertaEvento> offlist = (List<OffertaEvento>) controller.findByCustom(ls,TipoOfferta.OffertaEvento);
        /*(List<OffertaEvento>)*/
        /*List<OffertaEvento> */

        /*
        OffertaEventoBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (OffertaEvento off : offlist) {

                offbean = new OffertaEventoBean();
                offbean.setOfdateexpired(off.getDataScadenza().toString());
                offbean.setOfname(off.getNome());
                offbean.setOftype(off.getTipologia());
                offbean.setOfprice((off.getPrezzo()));
                offbean.setOfid(off.getEveID());
                offbean.setOfcity(off.getCittà());
                this.offerList.add(offbean);
            }
        }*/
        return fromEvtoEvBean(offlist) == null;

        //return offlist != null;

    }

}