package newpackage.Controllers;

import newpackage.*;
import newpackage.Beans.OffertaEventoBean;
import newpackage.Beans.OffertaPernottoBean;
import newpackage.Beans.OffertaTrasportoBean;
import newpackage.Beans.PacchettoBean;
import newpackage.DAOFactory.DAOFactory;
import newpackage.EntityPackage.OffertaEvento;
import newpackage.EntityPackage.OffertaPernotto;
import newpackage.EntityPackage.OffertaTrasporto;
import newpackage.Enumerations.TipoOfferta;

import java.util.ArrayList;
import java.util.Iterator;

public class PagamentoController {
    private static PagamentoController instance;

    public static PagamentoController getInstance() {
        if (instance == null)
            instance = new PagamentoController();
        return instance;
    }

    private PagamentoController() {
    }

    public void denyPay(ArrayList<Object> discardList){
        for(Object discardItem : discardList){
            if(discardItem instanceof PacchettoBean){
                DAOFactory.getPacchettoDAO().discardBuyPack(((PacchettoBean) discardItem).getId());
            }
            if(discardItem instanceof OffertaEventoBean){
                DAOFactory.getDAOFactory(TipoOfferta.OffertaEvento).getOffertaDAO().discardBuyOf(((OffertaEventoBean) discardItem).getOfid(),OffertaEvento.class);
            }
            if(discardItem instanceof OffertaPernottoBean){
                DAOFactory.getDAOFactory(TipoOfferta.OffertaPernotto).getOffertaDAO().discardBuyOf(((OffertaPernottoBean) discardItem).getOfid(),OffertaPernotto.class);
            }
            if(discardItem instanceof OffertaTrasportoBean){
                DAOFactory.getDAOFactory(TipoOfferta.OffertaTrasporto).getOffertaDAO().discardBuyOf(((OffertaTrasportoBean) discardItem).getOfid(),OffertaTrasporto.class);
            }
        }
    }


    public Object Pay(ArrayList<Object> itemlist,int idcart){//ArrayList<Pacchetto> lp, ArrayList<OffertaEvento> aoe, ArrayList<OffertaPernotto> aop, ArrayList<OffertaTrasporto> aot){
        DBResourcesManager.initHibernate();

        Iterator<Object> iter = itemlist.iterator();
        ArrayList<Object> discardList = new ArrayList<Object>();

        while(iter.hasNext()){
            Object o = iter.next();
            if(o instanceof PacchettoBean) {
                PacchettoBean pb = (PacchettoBean) o;
                if(!DAOFactory.getPacchettoDAO().checkToBuy(pb.getId())) {
                    denyPay(discardList);
                    return pb;
                }
                discardList.add(pb);
            }

            else if(o instanceof OffertaEventoBean){
                OffertaEventoBean ofe = (OffertaEventoBean) o;
                if(!DAOFactory.getDAOFactory(TipoOfferta.OffertaEvento).getOffertaDAO().checkToBuy(ofe.getOfid(),OffertaEvento.class)){
                    denyPay(discardList);
                    return ofe;
                }
                discardList.add(ofe);
            }

            else if(o instanceof OffertaPernottoBean){
                OffertaPernottoBean ofe = (OffertaPernottoBean) o;
                if(!DAOFactory.getDAOFactory(TipoOfferta.OffertaPernotto).getOffertaDAO().checkToBuy(ofe.getOfid(),OffertaPernotto.class)){
                    denyPay(discardList);
                    return ofe;
                }
                discardList.add(ofe);

            }

            else if(o instanceof OffertaTrasportoBean){
                OffertaTrasportoBean ofe = (OffertaTrasportoBean) o;
                if(!DAOFactory.getDAOFactory(TipoOfferta.OffertaTrasporto).getOffertaDAO().checkToBuy(ofe.getOfid(),OffertaTrasporto.class)){
                    denyPay(discardList);
                    return ofe;
                }
                discardList.add(ofe);
            }
        }

        DAOFactory.getCarrelloDAO().payFromCart(idcart);
        return null;

    }


}
