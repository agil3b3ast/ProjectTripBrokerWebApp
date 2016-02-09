package newpackage.DAO;

import newpackage.DBResourcesManager;
import newpackage.EntityPackage.OffertaTrasporto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;


public class OffertaTrasportoDAO extends OffertaDAO {

    @Override
    public Object getList() {
        Session s = DBResourcesManager.getSession();

        String query = "from OffertaTrasporto offertaTrasporto where offertaTrasporto.toBuy = true order by offertaTrasporto.prezzo";
        @SuppressWarnings("unchecked")
        List<OffertaTrasporto> offerte = s.createQuery(query).setMaxResults(10).list();
        if(offerte.size()>0) {
            s.close();
            return offerte;
        }else {
            s.close();
            return null;
        }
    }

    @Override
    public  Object findOff(String id) {
        Session s = DBResourcesManager.getSession();
        String query = "from OffertaTrasporto offertaTrasporto where offertaTrasporto.trasID = '"+id+"'";
        @SuppressWarnings("unchecked")
        List<OffertaTrasporto> offerte = s.createQuery(query).list();
        if(offerte.size()>0) {
            s.close();
            return offerte.get(0);
        }else {
            s.close();
            return null;
        }
    }

    @Override
    public Object findtype(String type) {
        Session s = DBResourcesManager.getSession();
        String query = "from OffertaTrasporto offertaTrasporto where offertaTrasporto.toBuy = true and offertaTrasporto.tipologia = '"+type+"' order by offertaTrasporto.prezzo";
        @SuppressWarnings("unchecked")
        List<OffertaTrasporto> offerte = s.createQuery(query).setMaxResults(10).list();
        if(offerte.size()>0){
            s.close();
            return offerte;}
        else {
            s.close();
            return null;
        }
    }


    @Override
    public void modPrezzo(int trasID,int percent)
    {
        Session s = DBResourcesManager.getSession();
        int val;

        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            OffertaTrasporto offertaTrasporto = (OffertaTrasporto) s.get(OffertaTrasporto.class,trasID);

            val = offertaTrasporto.getPrezzo();

            offertaTrasporto.setPrezzo(val + val*percent/100);

            s.update(offertaTrasporto);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        finally {
            s.close();
        }

    }

    @Override
    public void delof(int id) throws HibernateException
    {
        Session s = DBResourcesManager.getSession();

        Transaction tx = null;

        OffertaTrasporto offerta = (OffertaTrasporto) s.get(OffertaTrasporto.class , id);

        try {
            tx = s.beginTransaction();
            s.delete(offerta);
            tx.commit();
        }

        catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            s.close();
        }

    }

    @Override
    public Object customSearch(List<String> ls){
        Session s = DBResourcesManager.getSession();
        String initquery = "from OffertaTrasporto offertaTrasporto";

        List<String> strings = new LinkedList<String>();


        if (!ls.isEmpty()) {
            initquery = initquery + " where ";
        }

        for (int i = 0; i < ls.size(); i++) {
            if (!ls.get(i).equals("") && i == 0)
                strings.add("offertaTrasporto.città = '" + ls.get(i) +"'");
            if (!ls.get(i).equals("") && i == 1) {
                try {
                    System.out.println(ls.get(i));
                    SimpleDateFormat format = new SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH);
                    java.util.Date parsed = format.parse(ls.get(i));
                    java.sql.Date newdate = new java.sql.Date(parsed.getTime());
                    strings.add("offertaTrasporto.dataScadenza < '" + newdate + "'");
                }
                catch(java.text.ParseException e){
                    System.out.println("Exception : ParseException");
                }
            }
            if (!ls.get(i).equals("") && i == 2)
                strings.add("offertaTrasporto.nome = '" + ls.get(i) + "'");
            if (!ls.get(i).equals("") && i == 3) {
                if(ls.get(i).equals("1"))
                    strings.add("offertaTrasporto.prezzo < '100'");
                if(ls.get(i).equals("2"))
                    strings.add("offertaTrasporto.prezzo > '100' && offertaTrasporto.prezzo < '500'");
                if(ls.get(i).equals("3"))
                    strings.add("offertaTrasporto.prezzo > '500'");
            }
            if (!ls.get(i).equals("") && i == 4)
                strings.add("offertaTrasporto.tipologia = '" + ls.get(i) + "'");
            if (!ls.get(i).equals("") && i == 5)
                strings.add("offertaTrasporto.cittàPartenza = '" + ls.get(i) + "'");
            if (!ls.get(i).equals("") && i == 6)
                strings.add("offertaTrasporto.durata <= '" + ls.get(i) + "'");
        }

        String joinedstring = String.join(" and ",strings);

        String query = initquery + joinedstring;
        List<OffertaTrasporto> offerte = s.createQuery(query).setMaxResults(10).list();
        if(offerte.size()>0){
            s.close();
            return offerte;}
        else {
            s.close();
            return null;
        }
    }
}
