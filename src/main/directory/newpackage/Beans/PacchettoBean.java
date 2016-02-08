package newpackage.Beans;

import newpackage.DAOFactory.DAOFactory;
import newpackage.DBResourcesManager;
import newpackage.EntityPackage.OffertaEvento;
import newpackage.EntityPackage.OffertaPernotto;
import newpackage.EntityPackage.OffertaTrasporto;
import newpackage.EntityPackage.Pacchetto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alessandro on 08/01/2016.
 */
public class PacchettoBean implements Serializable{
    private String pname;
    private int pprice;
    private boolean pstate;
    private OffertaPernottoBean pofpernotto;
    private OffertaTrasportoBean poftrasporto;
    private ArrayList<OffertaEventoBean> pofevento;
    private ArrayList<PacchettoBean> plist;
    private int id;

    public PacchettoBean(){
        this.pname = "";
        this.pofpernotto = new OffertaPernottoBean();
        this.poftrasporto = new OffertaTrasportoBean();
        this.pofevento = new ArrayList<OffertaEventoBean>();
        this.plist = new ArrayList<PacchettoBean>();
    }

    public void setId(int newid){this.id = newid;}
    public int getId(){return id;}
    public String getPname(){return pname;}
    public int getPprice(){return pprice;}
    public boolean getPstate(){return pstate;}
    public OffertaPernottoBean getPofpernotto(){return pofpernotto;}
    public OffertaTrasportoBean getPoftrasporto(){return poftrasporto;}
    public ArrayList<OffertaEventoBean> getPofevento(){return pofevento;}
    public ArrayList<PacchettoBean> getPlist(){return plist;}

    public void setPlist(ArrayList<PacchettoBean> pnewlist){this.plist = pnewlist;}
    public void setPname(String newname){this.pname = newname;}
    public void setPprice(int newprice){this.pprice = newprice;}
    public void setPoftrasporto(OffertaTrasporto newoftrasporto){
        this.poftrasporto.setOftype(newoftrasporto.getTipologia());
        this.poftrasporto.setOfdateexpired(newoftrasporto.getDataScadenza().toString());
        this.poftrasporto.setOfprice(newoftrasporto.getPrezzo());
        this.poftrasporto.setOfname(newoftrasporto.getNome());
        this.poftrasporto.setOfid(newoftrasporto.getTrasID());
        this.poftrasporto.setCityFrom(newoftrasporto.getCittàPartenza());
        this.poftrasporto.setOfcity(newoftrasporto.getCittà());
    }
    public void setPofpernotto(OffertaPernotto newofpernotto){
        this.pofpernotto.setOftype(newofpernotto.getTipologia());
        this.pofpernotto.setOfdateexpired(newofpernotto.getDataScadenza().toString());
        this.pofpernotto.setOfprice(newofpernotto.getPrezzo());
        this.pofpernotto.setOfname(newofpernotto.getNome());
        this.pofpernotto.setOfid(newofpernotto.getPerID());
        this.pofpernotto.setOfcity(newofpernotto.getCittà());
        this.pofpernotto.setNumberOfNights(String.valueOf(newofpernotto.getNumeroNotti()));
        this.pofpernotto.setStars(String.valueOf(newofpernotto.getStelle()));
    }
    public void setPofevento(List<OffertaEvento> loe){
        OffertaEventoBean offertaEventoBean = new OffertaEventoBean();
        for(OffertaEvento offertaEvento : loe){
            offertaEventoBean.setOfname(offertaEvento.getNome());
            offertaEventoBean.setOfdateexpired(offertaEvento.getDataScadenza().toString());
            offertaEventoBean.setOftype(offertaEvento.getTipologia());
            offertaEventoBean.setOfprice(offertaEvento.getPrezzo());
            offertaEventoBean.setOfid(offertaEvento.getEveID());
            offertaEventoBean.setOfcity(offertaEvento.getCittà());
            this.pofevento.add(offertaEventoBean);
        }
    }
    public void getPofevento(ArrayList<OffertaEventoBean> newlistofevento){this.pofevento = newlistofevento;}

    public boolean selectAll(){
        DBResourcesManager.initHibernate();

        //PacchettoController controller = PacchettoController.getInstance();

        List<Pacchetto> plist = DAOFactory.getPacchettoDAO().getList();//controller.findAll(null);
        PacchettoBean pbean;
        this.plist = null;
        if(plist != null && plist.size()>0) {

            this.plist = new ArrayList<PacchettoBean>();
            for (Pacchetto p: plist) {

                pbean = new PacchettoBean();
                pbean.setPname(p.getNome());
                pbean.setPprice(p.getPrezzo());
                pbean.pofpernotto = new OffertaPernottoBean();
                pbean.setPofpernotto(p.getOffertaPernotto());
                pbean.poftrasporto = new OffertaTrasportoBean();
                pbean.setPoftrasporto(p.getOffertaTrasporto());
                pbean.pofevento = new ArrayList<OffertaEventoBean>();
                pbean.setPofevento(p.getOffertaEvento());
                pbean.setId(p.getId());
                //opb.setOfname(p.getOffertaPernotto().getNome());
                //opb.setOftype(p.getOffertaPernotto().getTipologia());
                //opb.setOfdateexpired(p.getOffertaPernotto().getDataScadenza());
                //opb.setOfprice(p.getOffertaPernotto().getPrezzo());
                //pbean.setPofpernotto(p.getOffertaPernotto());

                this.plist.add(pbean);
            }
        }
        return this.plist == null;
    }



}
