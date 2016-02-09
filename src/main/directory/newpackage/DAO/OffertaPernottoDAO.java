package newpackage.DAO;

import newpackage.DBResourcesManager;
import newpackage.EntityPackage.OffertaEvento;
import newpackage.EntityPackage.OffertaPernotto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;


public class OffertaPernottoDAO extends OffertaDAO {


    @Override
    public Object getList() {
        Session s = DBResourcesManager.getSession();

        String query = "from OffertaPernotto offertaPernotto where offertaPernotto.toBuy = true order by offertaPernotto.prezzo";
        @SuppressWarnings("unchecked")
        List<OffertaPernotto> offerte = s.createQuery(query).setMaxResults(10).list();
        if(offerte.size()>0){
            s.close();
            return offerte;}
        else {
            s.close();
            return null;
        }
    }

    @Override
    public Object findtype(String type) {
        Session s = DBResourcesManager.getSession();
        String query = "from OffertaPernotto offertaPernotto where offertaPernotto.toBuy = true and offertaPernotto.tipologia = '"+type+"' order by offertaPernotto.prezzo";
        @SuppressWarnings("unchecked")
        List<OffertaPernotto> offerte = s.createQuery(query).setMaxResults(10).list();
        if(offerte.size()>0) {
            s.close();
            return offerte;
        }
        else {
            s.close();
            return null;
        }
    }

    @Override
    public  Object findOff(String id) {
        Session s = DBResourcesManager.getSession();
        String query = "from OffertaPernotto offertaPernotto where offertaPernotto.perID = '"+id+"'";
        @SuppressWarnings("unchecked")
        List<OffertaPernotto> offerte = s.createQuery(query).list();
        if(offerte.size()>0){
            s.close();
            return offerte.get(0);}
        else {
            s.close();
            return null;
        }
    }

    @Override
    public void modPrezzo(int perID,int percent)
    {
        Session s = DBResourcesManager.getSession();
        int val;
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            OffertaPernotto offertaPernotto = (OffertaPernotto) s.get(OffertaPernotto.class,perID);


            val = offertaPernotto.getPrezzo();

            offertaPernotto.setPrezzo(val + val*percent/100);
            s.update(offertaPernotto);
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
        OffertaPernotto offerta = (OffertaPernotto) s.get(OffertaPernotto.class , id);
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
        String initquery = "from OffertaPernotto offertaPernotto";
        List<String> strings = new LinkedList<String>();


        if (!ls.isEmpty()) {
            initquery = initquery + " where offertaPernotto.toBuy = true and ";
        }

        for (int i = 0; i < ls.size(); i++) {
            if (!ls.get(i).equals("") && i == 0)
                strings.add("offertaPernotto.città = '" + ls.get(i) +"'");
            if (!ls.get(i).equals("") && i == 1) {
                try {
                    System.out.println(ls.get(i));
                    SimpleDateFormat format = new SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH);
                    java.util.Date parsed = format.parse(ls.get(i));
                    java.sql.Date newdate = new java.sql.Date(parsed.getTime());
                    strings.add("offertaPernotto.dataScadenza < '" + newdate + "'");
                }
                catch(java.text.ParseException e){
                    System.out.println("Exception : ParseException");
                }
            }
            if (!ls.get(i).equals("") && i == 2)
                strings.add("offertaPernotto.nome = '" + ls.get(i) + "'");
            if (!ls.get(i).equals("") && i == 3) {
                if(ls.get(i).equals("1"))
                    strings.add("offertaPernotto.prezzo < '100'");
                if(ls.get(i).equals("2"))
                    strings.add("offertaPernotto.prezzo > '100' && offertaEvento.prezzo < '500'");
                if(ls.get(i).equals("3"))
                    strings.add("offertaPernotto.prezzo > '500'");
            }
            if (!ls.get(i).equals("") && i == 4)
                strings.add("offertaPernotto.tipologia = '" + ls.get(i) + "'");
            if (!ls.get(i).equals("") && i == 5)
                strings.add("offertaPernotto.numeroNotti = '" + ls.get(i) + "'");
            if (!ls.get(i).equals("") && i == 6)
                strings.add("offertaPernotto.stelle = '" + ls.get(i) + "'");
        }

        String joinedstring = String.join(" and ",strings);
        String query = initquery + joinedstring;
        List<OffertaEvento> offerte = s.createQuery(query).setMaxResults(10).list();
        if(offerte.size()>0) {
            s.close();
            return offerte;
        }else {
            s.close();
            return null;
        }
    }
}
