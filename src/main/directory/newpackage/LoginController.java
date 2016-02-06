package newpackage;

import newpackage.DAOFactory.DAOFactory;
import newpackage.EntityPackage.WebClient;

import java.util.List;

public class LoginController {

    private static LoginController instance;

    public static LoginController getInstance() {
        if (instance == null)
            instance = new LoginController();
        return instance;
    }

    private LoginController() {
    }

    /**
     * Carica l'utente corrispondente alla coppia username/password in input
     *
     * @param username username
     * @param password password
     * @return l'utente loggato oppure null se nessun utente corrisponde alla coppia username/password
     */
    public WebClient login(String username, String password) {
        //newpackage.Utente u = newpackage.UtendeDao.findByNameAndPassword(username, password);
        DBResourcesManager.initHibernate();
        List<WebClient> webClient = DAOFactory.getWebClientDAO().findSelectedUser(username,password);
        //DBResourcesManager.shutdown();
        if(webClient != null){
            if(webClient.size()!=1){
                return null;
            }
            return webClient.get(0);
        }
        return null;
    }

}
