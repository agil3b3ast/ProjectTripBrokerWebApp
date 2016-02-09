package newpackage.Controllers;

import newpackage.DAOFactory.DAOFactory;
import newpackage.DBResourcesManager;
import newpackage.EntityPackage.Pacchetto;

public class PacchettoController {

    private static PacchettoController instance;

    public static PacchettoController getInstance() {
        if (instance == null)
            instance = new PacchettoController();
        return instance;
    }

    private PacchettoController() {
    }


    public Pacchetto findByID(String idtofind){
        DBResourcesManager.initHibernate();

        Pacchetto p = DAOFactory.getPacchettoDAO().findByID(Integer.valueOf(idtofind));

        return p;
    }



}
