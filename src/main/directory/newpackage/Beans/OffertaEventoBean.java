package newpackage.Beans;

import newpackage.Controllers.OffertaController;
import newpackage.DAOFactory.DAOFactory;
import newpackage.DBResourcesManager;
import newpackage.EntityPackage.OffertaEvento;
import newpackage.Enumerations.TipoOfferta;

import java.util.ArrayList;
import java.util.List;

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

    public boolean selectAll(){
        if(this.oftype == ""){
            return false;
        }
        DBResourcesManager.initHibernate();

        List<OffertaEvento> offlist = null;

        if(this.oftype == null) {
            offlist = (List<OffertaEvento>) DAOFactory.getDAOFactory(TipoOfferta.OffertaEvento).getOffertaDAO().getList();
        }
        else{
            offlist = (List<OffertaEvento>) DAOFactory.getDAOFactory(TipoOfferta.OffertaEvento).getOffertaDAO().findtype(this.oftype);
        }


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

        if(this.oftype == "" && this.ofdateexpired == "" && this.ofcity == "" && this.ofname==""){
            return false;
        }

        if(this.ofcity.contains(" ")){
            return false;
        }
        if(this.ofdateexpired.contains(" ")){
            return false;
        }
        if(this.ofname.contains(" ")){
            return false;
        }

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