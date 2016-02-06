package newpackage.DAO;

import newpackage.DBResourcesManager;
import newpackage.EntityPackage.Carrello;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Created by Alessandro on 04/02/2016.
 */
public class CarrelloDAO {

    public void store(Carrello e) {
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
}
