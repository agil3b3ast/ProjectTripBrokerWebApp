package newpackage.DAO;

import newpackage.DBResourcesManager;
import newpackage.EntityPackage.Offerta;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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
