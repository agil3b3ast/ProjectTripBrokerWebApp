package newpackage.DAO;

/**
 * Created by Alessandro on 04/02/2016.
 */

import newpackage.DBResourcesManager;
import newpackage.EntityPackage.WebClient;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class WebClientDAO {

    public void store(WebClient e) {
        // start a session
        Session s = DBResourcesManager.getSession();
        // in the given session, start a transaction
        s.beginTransaction();

        // within the transaction, save the event
        try {
            s.save(e); //might throw exception
        }
        catch(HibernateException ex) {
        }

        // commit the current transaction of the session
        s.getTransaction().commit();

        // close session
        s.close();
    }

    public List<WebClient> findSelectedUser(String nickname, String password) {
        Session s = DBResourcesManager.getSession();

//        String query = "from User user where user.usID = '" + name + "' and user.password = '" + password + "'";
        String query = "from WebClient webclient where webclient.nickname = '" + nickname + "' and webclient.password = '" + password + "'";
        System.out.println(query);
        @SuppressWarnings("unchecked")
        List<WebClient> webClients = s.createQuery(query).list();
        if (webClients.size() > 1){
            System.out.println("Query ha ritornato più di un oggetto");
            return null;
        }
        else if(webClients.size() == 1){
            System.out.println("Query eseguita correttamente");
            return webClients;
        }
        else{
            return null;
        }
    }

}
