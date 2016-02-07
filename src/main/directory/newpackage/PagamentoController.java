package newpackage;

import newpackage.DAOFactory.DAOFactory;
import newpackage.EntityPackage.OffertaEvento;
import newpackage.EntityPackage.OffertaPernotto;
import newpackage.EntityPackage.OffertaTrasporto;
import newpackage.EntityPackage.Pacchetto;
import org.hibernate.HibernateException;
import org.hibernate.type.AnyType;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Alessandro on 11/01/2016.
 */
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

        /*Iterator<Pacchetto> iter = lp.iterator();

        while (iter.hasNext()) {
            Pacchetto p = iter.next();

            try{
            DAOFactory.getPacchettoDAO().delPack(p.getId());
            }
            catch (HibernateException e){
                System.out.println("Offerta non si può cancellare");
                return false;
            }
            iter.remove();
        }

        Iterator<OffertaEvento> itere = aoe.iterator();

        while (itere.hasNext()) {
            OffertaEvento oe = itere.next();
            //DBResourcesManager.shutdown();
            try {
                DAOFactory.getDAOFactory(TipoOfferta.OffertaEvento).getOffertaDAO().delof(oe.getEveID());
            }
            catch(HibernateException e) {
                System.out.println("Offerta non si può cancellare");
                return false;
            }

            itere.remove();
        }


        Iterator<OffertaPernotto> iterp = aop.iterator();

        while (iterp.hasNext()) {
            OffertaPernotto oe = iterp.next();

            try {
                DAOFactory.getDAOFactory(TipoOfferta.OffertaPernotto).getOffertaDAO().delof(oe.getPerID());
            }
            catch (HibernateException e){
                System.out.println("Offerta non si può cancellare");
                return false;
            }
            iterp.remove();

        }

        Iterator<OffertaTrasporto> itert = aot.iterator();

        while (itert.hasNext()) {
            OffertaTrasporto oe = itert.next();
            try{
            DAOFactory.getDAOFactory(TipoOfferta.OffertaTrasporto).getOffertaDAO().delof(oe.getTrasID());
            }
            catch (HibernateException e){
                System.out.println("Offerta non si può cancellare");
                return false;
            }

            itert.remove();

        }*/

        //DBResourcesManager.shutdown();
        //return true;
    }


}
