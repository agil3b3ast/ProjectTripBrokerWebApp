package newpackage.Controllers;

import newpackage.DAOFactory.DAOFactory;
import newpackage.DBResourcesManager;
import newpackage.Enumerations.TipoOfferta;

import java.util.List;

public class OffertaController {

    private static OffertaController instance;

    public static OffertaController getInstance() {
        if (instance == null)
            instance = new OffertaController();
        return instance;
    }

    private OffertaController() {
    }

    public Object findByID(TipoOfferta tipoOfferta, String idtofind){
        DBResourcesManager.initHibernate();


        int id = Integer.valueOf(idtofind);
        if(id <0){
            return null;
        }


        Object ls = null;

        ls = DAOFactory.getDAOFactory(tipoOfferta).getOffertaDAO().findOff(idtofind);
        return ls;
    }

    public Object findByCustom(List<String> list,TipoOfferta tipoOfferta){
        DBResourcesManager.initHibernate();


        if(list == null){
            return null;
        }

        for(String s: list){
            if(s.indexOf(" ")>=0){
                return null;
            }
        }


        Object ls = null;

        ls = DAOFactory.getDAOFactory(tipoOfferta).getOffertaDAO().customSearch(list);
        return ls;
    }

}
