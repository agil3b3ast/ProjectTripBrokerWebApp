package newpackage.Beans;

import newpackage.Controllers.OffertaController;
import newpackage.DAOFactory.DAOFactory;
import newpackage.DBResourcesManager;
import newpackage.EntityPackage.OffertaPernotto;
import newpackage.Enumerations.TipoOfferta;

import java.util.ArrayList;
import java.util.List;

public class OffertaPernottoBean extends OffertaBean {
    private String oftype;
    private int ofid;
    private String numberOfNights;
    private String stars;

    public OffertaPernottoBean(){
        super();
        this.oftype = "";
        this.numberOfNights = "";
        this.stars = "";
    }

    public String getOftype(){return this.oftype;}
    public void setOftype(String newoftype){this.oftype = newoftype;}
    public int getOfid(){return this.ofid;}
    public void setOfid(int newid){this.ofid = newid;}
    public String getNumberOfNights(){return this.numberOfNights;}
    public String getStars(){return this.stars;}
    public void setNumberOfNights(String newNumberOfNights){this.numberOfNights = newNumberOfNights;}
    public void setStars(String newStars){this.stars = newStars;}
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
    //@Override
    public boolean selectAll(){
        if(this.oftype == ""){
            //this.oftype = "Concerto";
            return false;
        }
        DBResourcesManager.initHibernate();

        List<OffertaPernotto> offlist = null;

        if(this.oftype == null) {
            offlist = (List<OffertaPernotto>) DAOFactory.getDAOFactory(TipoOfferta.OffertaPernotto).getOffertaDAO().getList();
        }
        else{
            offlist = (List<OffertaPernotto>) DAOFactory.getDAOFactory(TipoOfferta.OffertaPernotto).getOffertaDAO().findtype(this.oftype);
        }

        //OffertaController controller = OffertaController.getInstance();

        //List<OffertaPernotto> offlist = (List<OffertaPernotto>) controller.findAll(TipoOfferta.OffertaPernotto,this.oftype);
        OffertaPernottoBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (OffertaPernotto off : offlist) {

                offbean = new OffertaPernottoBean();
                offbean.setOfdateexpired(off.getDataScadenza().toString());
                offbean.setOfname(off.getNome());
                offbean.setOftype(off.getTipologia());
                offbean.setOfprice((off.getPrezzo()));
                offbean.setOfid(off.getPerID());

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
        ls.add(getNumberOfNights());
        ls.add(getStars());
        return ls;
    }

    public ArrayList<OffertaBean> fromPertoPerBean(List<OffertaPernotto> offlist){
        OffertaPernottoBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (OffertaPernotto off : offlist) {

                offbean = new OffertaPernottoBean();
                offbean.setOfdateexpired(off.getDataScadenza().toString());
                offbean.setOfname(off.getNome());
                offbean.setOftype(off.getTipologia());
                offbean.setOfprice((off.getPrezzo()));
                offbean.setOfid(off.getPerID());
                offbean.setNumberOfNights(String.valueOf(off.getNumeroNotti()));
                offbean.setStars(String.valueOf(off.getStelle()));
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
        List<OffertaPernotto> offlist = (List<OffertaPernotto>) controller.findByCustom(ls,TipoOfferta.OffertaPernotto);
        /*OffertaPernottoBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (OffertaPernotto off : offlist) {

                offbean = new OffertaPernottoBean();
                offbean.setOfdateexpired(off.getDataScadenza().toString());
                offbean.setOfname(off.getNome());
                offbean.setOftype(off.getTipologia());
                offbean.setOfprice((off.getPrezzo()));
                offbean.setOfid(off.getPerID());
                offbean.setNumberOfNights(String.valueOf(off.getNumeroNotti()));
                offbean.setStars(String.valueOf(off.getStelle()));
                offbean.setOfcity(off.getCittà());
                this.offerList.add(offbean);
            }
        }*/
        return fromPertoPerBean(offlist) == null;
        //return this.offerList == null;
    }
}