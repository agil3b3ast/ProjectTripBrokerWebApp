package newpackage.DAO;

/**
 * Created by Alessandro on 07/01/2016.
 */

import newpackage.DBResourcesManager;
import newpackage.EntityPackage.Offerta;
import newpackage.EntityPackage.OffertaEvento;
import org.hibernate.Session;

import java.util.List;


public class OffertaDaoAnnotations{

    public static void store(Offerta e) {
        // start a session
        Session s = DBResourcesManager.getSession();
        // in the given session, start a transaction
        s.beginTransaction();

        // within the transaction, save the Offerta
        s.save(e);

        // commit the current transaction of the session
        s.getTransaction().commit();

        // close session
        s.close();
    }

    public static List<OffertaEvento> findAllOffertaEntitysA(String typetable, String typesearch) {
        Session s = DBResourcesManager.getSession();

        @SuppressWarnings("unchecked")
        //String sql_query = "SELECT * FROM "+typetable+" as tt WHERE tt.tipologia = '"+typesearch+"';";
        String sql_query = "from OffertaEvento oee where oee.tipologia = '"+typesearch+"'";
        System.out.println(sql_query);
        List<OffertaEvento> offers = s.createQuery(sql_query).list();

        return offers;
    }

    public static List<Offerta> findAllOffertaEntitysB() {
        Session s = DBResourcesManager.getSession();

        @SuppressWarnings("unchecked")
        List<Offerta> offers = s.createCriteria(Offerta.class).list();

        return offers;
    }

    public static void updateOffertaEntity(Offerta toUpdate) {
        Session s = DBResourcesManager.getSession();
        s.beginTransaction();
        s.update(toUpdate);
        s.getTransaction().commit();
    }

    public static void deleteOffertaEntity(Offerta toDelete) {
        Session s = DBResourcesManager.getSession();
        s.beginTransaction();
        s.delete(toDelete);
        s.getTransaction().commit();
    }
}
