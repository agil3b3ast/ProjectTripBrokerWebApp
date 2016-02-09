package newpackage.Controllers;

import newpackage.DAOFactory.DAOFactory;
import newpackage.DBResourcesManager;
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

    public WebClient login(String username, String password) {
        DBResourcesManager.initHibernate();
        List<WebClient> webClient = DAOFactory.getWebClientDAO().findSelectedUser(username,password);
        if(webClient != null){
            if(webClient.size()!=1){
                return null;
            }
            return webClient.get(0);
        }
        return null;
    }

}
