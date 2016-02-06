package newpackage.DAO;

import newpackage.DBResourcesManager;
import newpackage.EntityPackage.Carrello;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

    public Carrello findByID(String idtofind){
        try {
            Session s = DBResourcesManager.getSession();
            String query = "from Carrello carrello where carrello.id=" + idtofind + "";
            List<Carrello> p = s.createQuery(query).list();
            if (p.size() > 1 || p.isEmpty()) {
                System.out.println("Lista con più di un elemento o vuota");
                return null;
            }
            s.close();
            return p.get(0);
        }
        catch (HibernateException e){
            System.out.println("Hibernate exception");
            return null;
        }
    }

    public Carrello addToCart(String idtofind,Object item){
        try {
            Session s = DBResourcesManager.getSession();

            Transaction tx = s.beginTransaction();

            String query = "from Carrello carrello where carrello.id=" + idtofind + "";
            List<Carrello> p = s.createQuery(query).list();
            if (p.size() > 1 || p.isEmpty()) {
                System.out.println("Lista con più di un elemento o vuota");
                return null;
            }
            Carrello c = p.get(0);

            if(!c.addItemToCart(item))
                return null;

            s.update(c);
            tx.commit();
            s.close();
            return c;

        }
        catch (HibernateException e){
            System.out.println("Hibernate exception");
            return null;
        }
    }

    public Carrello removeFromCart(String idtofind,Object item){
        try {
            Session s = DBResourcesManager.getSession();

            Transaction tx = s.beginTransaction();

            String query = "from Carrello carrello where carrello.id=" + idtofind + "";
            List<Carrello> p = s.createQuery(query).list();
            if (p.size() > 1 || p.isEmpty()) {
                System.out.println("Lista con più di un elemento o vuota");
                return null;
            }
            Carrello c = p.get(0);

            if(!c.removeItemFromCart(item))
                return null;

            s.update(c);
            tx.commit();
            s.close();
            return c;

        }
        catch (HibernateException e){
            System.out.println("Hibernate exception");
            return null;
        }
    }


}
