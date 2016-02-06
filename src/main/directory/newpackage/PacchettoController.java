package newpackage;

import newpackage.DAOFactory.DAOFactory;
import newpackage.EntityPackage.Pacchetto;

import java.util.List;

/**
 * Created by Alessandro on 08/01/2016.
 */
public class PacchettoController {

    private static PacchettoController instance;

    public static PacchettoController getInstance() {
        if (instance == null)
            instance = new PacchettoController();
        return instance;
    }

    private PacchettoController() {
    }

    public List<Pacchetto> findAll(String typesearch){

        DBResourcesManager.initHibernate();

        //ArrayList<Offerta> ls = OffertaDao.findAll(typetable,typesearch);
        //List<OffertaEvento> ls = OffertaDaoAnnotations.findAllOffertaEntitysA(typetable,typesearch);

        List<Pacchetto> ls = null;

        if(typesearch == null) {
            ls = DAOFactory.getPacchettoDAO().getList();
        }
        DBResourcesManager.shutdown();
        return ls;
    }

    public Pacchetto findByID(String idtofind){
        DBResourcesManager.initHibernate();

        Pacchetto p = DAOFactory.getPacchettoDAO().findByID(idtofind);

        DBResourcesManager.shutdown();
        return p;
    }



}
