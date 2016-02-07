package newpackage.DAO;

import newpackage.DBResourcesManager;
import newpackage.EntityPackage.Pacchetto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Simone on 22/12/2015.
 */
public class PacchettoDAO {

    public void store(Pacchetto e) {
        // start a session
        Session s = DBResourcesManager.getSession();
        // in the given session, start a transaction
        s.beginTransaction();

        // within the transaction, save the event
        try {
            s.save(e); //might throw exception
        } catch (HibernateException ex) {
        }

        // commit the current transaction of the session
        s.getTransaction().commit();

        // close session
        s.close();
    }

    public  List<Pacchetto> getList() {
        Session s = DBResourcesManager.getSession();

        String query = "from Pacchetto pacchetto where pacchetto.stato = true and pacchetto.toBuy = true order by pacchetto.prezzo";
        @SuppressWarnings("unchecked")
        List<Pacchetto> pacchetto = s.createQuery(query).setMaxResults(10).list();
        if(pacchetto.size()>0) {
            if (pacchetto.get(0).getOffertaPernotto() == null) {
                System.out.println("Offerta pernotto non esistente");
            }
            else if(pacchetto.get(0).getOffertaTrasporto() == null){
                System.out.println("Offerta trasporto non esistente");
            }
            else if(pacchetto.get(0).getOffertaEvento() == null){
                System.out.println("Offerta evento non esistente");
            }
            s.close();
            return pacchetto;
        }
        else {
            s.close();
            return null;
        }
    }

    public Pacchetto findByID(int idtofind){
        Session s = DBResourcesManager.getSession();
        Pacchetto p = (Pacchetto)s.get(Pacchetto.class , idtofind);
        s.close();
        return p;
    }

    public  List<Pacchetto> findNotApproved() {
        Session s = DBResourcesManager.getSession();
        String query = "from Pacchetto pacchetto where pacchetto.stato=false";
        @SuppressWarnings("unchecked")
        List<Pacchetto> packs = s.createQuery(query).list();
        if (packs.size() > 0){
            s.close();
            return packs;
        }
        else {
            s.close();
            return null;
        }
    }

    public boolean checkToBuy(int id){
        Session s = DBResourcesManager.getSession();

        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            Pacchetto p = (Pacchetto)s.get(Pacchetto.class , id);
            if(!p.isToBuy()) {
                s.close();
                return false;
            }
            p.setToBuy(false);
            s.update(p);
            tx.commit();
            s.close();
            return true;
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public Pacchetto discardBuyPack(int id)
    {
        Session s = DBResourcesManager.getSession();

        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            Pacchetto p = (Pacchetto)s.get(Pacchetto.class , id);
            if(p != null){
                p.setToBuy(true);
                s.update(p);
                tx.commit();
            }
            s.close();
            return p;
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }

        return null;
    }

    public Pacchetto findBuyPack()
    {
        Session s = DBResourcesManager.getSession();

        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            String query = "from Pacchetto pacchetto where pacchetto.toBuy = true";
            Pacchetto p= (Pacchetto) s.createQuery(query).uniqueResult();
            if(p != null){
                p.setToBuy(false);
                s.update(p);
                tx.commit();
            }
            s.close();
            return p;
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }

        return null;
    }


     public void modPack(int id , String nome, int prezzo,boolean stato)
    {
        Session s = DBResourcesManager.getSession();

        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            Pacchetto pacchetto = (Pacchetto)s.get(Pacchetto.class , id);

            pacchetto.setNome(nome);
            pacchetto.setPrezzo(prezzo);
            pacchetto.setStato(stato);

            s.update(pacchetto);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        finally {
            s.close();
        }

    }

    public void delPack(int id) throws HibernateException
    {
        Session s = DBResourcesManager.getSession();

        Transaction tx = null;
        Pacchetto pacchetto = (Pacchetto)s.get(Pacchetto.class , id);
        try {
            tx = s.beginTransaction();
            s.delete(pacchetto);
            tx.commit();
        }
        /*
        catch (EJBTransactionRolledbackException e) {
            Throwable t = e.getCause();
            while ((t != null) && !(t instanceof ConstraintViolationException)) {
                t = t.getCause();
            }
            if (t instanceof ConstraintViolationException) {
                System.out.println("Offerta non rimovibile, presente in un pacchetto");
            }
        }*/
        catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            s.close();
            //DBResourcesManager.shutdown();
        }
    }


}
