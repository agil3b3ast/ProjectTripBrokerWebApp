package newpackage;

/**
 * Created by Alessandro on 08/01/2016.
 */

import newpackage.EntityPackage.OffertaTrasporto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alessandro on 08/01/2016.
 */

public class OffertaTrasportoBean extends OffertaBean{
    private String oftype;
    private int ofid;
    private String cityFrom;
    private String duration;

    public OffertaTrasportoBean(){
        super();
        this.oftype = "";
        this.cityFrom = "";
        this.duration = "";
    }

    public String getOftype(){return this.oftype;}
    public void setOftype(String newoftype){this.oftype = newoftype;}
    public int getOfid(){return this.ofid;}
    public void setOfid(int newid){this.ofid = newid;}
    public String getCityFrom(){return this.cityFrom;}
    public void setCityFrom(String newcityFrom){this.cityFrom= newcityFrom;}
    public String getDuration(){return this.duration;}
    public void setDuration(String newduration){this.duration = newduration;}
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

        List<OffertaTrasporto> offlist = (List<OffertaTrasporto>) controller.findAll(TipoOfferta.OffertaTrasporto,this.oftype);
        OffertaTrasportoBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (OffertaTrasporto off : offlist) {

                offbean = new OffertaTrasportoBean();
                offbean.setOfdateexpired(off.getDataScadenza().toString());
                offbean.setOfname(off.getNome());
                offbean.setOftype(off.getTipologia());
                offbean.setOfprice((off.getPrezzo()));
                offbean.setOfid(off.getTrasID());
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
        ls.add(getCityFrom());
        ls.add(getDuration());
        return ls;
    }

    public ArrayList<OffertaBean> fromTrastoTrasBean(List<OffertaTrasporto> offlist){
        OffertaTrasportoBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (OffertaTrasporto off : offlist) {

                offbean = new OffertaTrasportoBean();
                offbean.setOfdateexpired(off.getDataScadenza().toString());
                offbean.setOfname(off.getNome());
                offbean.setOftype(off.getTipologia());
                offbean.setOfprice((off.getPrezzo()));
                offbean.setOfid(off.getTrasID());
                offbean.setCityFrom(off.getCittàPartenza());
                offbean.setDuration(String.valueOf(off.getDurata()));
                offbean.setOfcity(off.getCittà());
                this.offerList.add(offbean);
            }
        }
        return this.offerList;
    }

    public boolean fillToFind(){
        List<String> ls = this.toStringList();

        OffertaController controller = OffertaController.getInstance();
        List<OffertaTrasporto> offlist = (List<OffertaTrasporto>) controller.findByCustom(ls,TipoOfferta.OffertaTrasporto);
        /*
        OffertaTrasportoBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (OffertaTrasporto off : offlist) {

                offbean = new OffertaTrasportoBean();
                offbean.setOfdateexpired(off.getDataScadenza().toString());
                offbean.setOfname(off.getNome());
                offbean.setOftype(off.getTipologia());
                offbean.setOfprice((off.getPrezzo()));
                offbean.setOfid(off.getTrasID());
                offbean.setCityFrom(off.getCittàPartenza());
                offbean.setDuration(String.valueOf(off.getDurata()));
                offbean.setOfcity(off.getCittà());
                this.offerList.add(offbean);
            }
        }*/
        return fromTrastoTrasBean(offlist) == null;
        //return this.offerList == null;
    }
}