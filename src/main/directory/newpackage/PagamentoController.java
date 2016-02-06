package newpackage;

import newpackage.DAOFactory.DAOFactory;
import newpackage.EntityPackage.OffertaEvento;
import newpackage.EntityPackage.OffertaPernotto;
import newpackage.EntityPackage.OffertaTrasporto;
import newpackage.EntityPackage.Pacchetto;
import org.hibernate.HibernateException;

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

    public boolean Pay(ArrayList<Pacchetto> lp, ArrayList<OffertaEvento> aoe, ArrayList<OffertaPernotto> aop, ArrayList<OffertaTrasporto> aot){
        DBResourcesManager.initHibernate();
        Iterator<Pacchetto> iter = lp.iterator();

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

        }

        //DBResourcesManager.shutdown();
        return true;
    }


}
