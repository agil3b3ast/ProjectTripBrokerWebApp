package newpackage.Controllers;

import newpackage.DAOFactory.DAOFactory;
import newpackage.DBResourcesManager;
import newpackage.EntityPackage.Pacchetto;

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

    /*
    public List<Pacchetto> findAll(String typesearch){

        DBResourcesManager.initHibernate();

        List<Pacchetto> ls = null;

        if(typesearch == null) {
            ls = DAOFactory.getPacchettoDAO().getList();
        }
        //DBResourcesManager.shutdown();
        return ls;
    }*/

    public Pacchetto findByID(String idtofind){
        DBResourcesManager.initHibernate();

        Pacchetto p = DAOFactory.getPacchettoDAO().findByID(Integer.valueOf(idtofind));

        //DBResourcesManager.shutdown();
        return p;
    }



}
