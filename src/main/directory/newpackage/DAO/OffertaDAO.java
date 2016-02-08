package newpackage.DAO;

import newpackage.DBResourcesManager;
import newpackage.EntityPackage.Offerta;
import newpackage.EntityPackage.OffertaEvento;
import newpackage.EntityPackage.OffertaPernotto;
import newpackage.EntityPackage.OffertaTrasporto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Alessandro on 08/01/2016.
 */
public abstract class OffertaDAO {

    public static void store(Offerta of) {
        Session s = DBResourcesManager.getSession();
        s.beginTransaction();
        try{
            s.save(of);
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        s.getTransaction().commit();
        s.close();
    }

    public abstract Object getList();
    public abstract Object findOff(String id);
    public abstract void modPrezzo(int id, int prezzo);
    public abstract Object findtype(String type);
    public abstract void delof(int id);
    public abstract Object customSearch(List<String> ls);

    public boolean checkToBuy(int id, Class c){
        Session s = DBResourcesManager.getSession();

        Transaction tx = null;
        try{
            tx = s.beginTransaction();


            Object res = (Object) s.get(c, id);

            if(res instanceof OffertaEvento) {
                OffertaEvento p = (OffertaEvento) res;

                if (!p.isToBuy()) {
                    s.close();
                    return false;
                }
                p.setToBuy(false);
                s.update(p);
                tx.commit();
                s.close();
                return true;
            }
            else if(res instanceof OffertaPernotto) {
                OffertaPernotto p = (OffertaPernotto) res;

                if (!p.isToBuy()) {
                    s.close();
                    return false;
                }
                p.setToBuy(false);
                s.update(p);
                tx.commit();
                s.close();
                return true;
            }
            else if(res instanceof OffertaTrasporto) {
                OffertaTrasporto p = (OffertaTrasporto) res;

                if (!p.isToBuy()) {
                    s.close();
                    return false;
                }
                p.setToBuy(false);
                s.update(p);
                tx.commit();
                s.close();
                return true;
            }
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public Offerta discardBuyOf(int id, Class c)
    {
        Session s = DBResourcesManager.getSession();

        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            Offerta p = (Offerta)s.get(c , id);
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

    public Offerta findBuyOff(Class c)
    {
        Session s = DBResourcesManager.getSession();

        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            String query = "from "+ c +" offerta where offerta.toBuy = true";
            Offerta p= (Offerta) s.createQuery(query).uniqueResult();
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

    /*public Object customSearch(Object object){
        String query = "from "+ object.getClass().getSimpleName() + " where ";

        System.out.println(object.getClass().getSimpleName() + "\n");
        Method[] methods = object.getClass().getMethods();
        for (Method m : methods) {
            int l = m.getName().length();
            if (m.getName().substring(0, 3).equals("get") && !m.getName().substring(l - 2, l).equals("ID") && !m.getName().equals("getClass"))
            {
                String s = m.getName().substring(0,1).toLowerCase();
                String attributeLower = s + m.getName().substring(1);
                query = query + attributeLower + " = ";
            }
        }
    }*/
}
