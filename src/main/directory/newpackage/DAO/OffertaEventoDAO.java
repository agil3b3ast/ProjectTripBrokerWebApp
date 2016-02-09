package newpackage.DAO;

import newpackage.DBResourcesManager;
import newpackage.EntityPackage.Offerta;
import newpackage.EntityPackage.OffertaEvento;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;


public class OffertaEventoDAO extends OffertaDAO {

    @Override
    public  Object getList() {

        Session s = DBResourcesManager.getSession();

        String query = "from OffertaEvento offertaEvento where offertaEvento.toBuy = true order by offertaEvento.prezzo";
        @SuppressWarnings("unchecked")
        List<OffertaEvento> offerte = s.createQuery(query).setMaxResults(10).list();
        if(offerte.size()>0){
            s.close();
            return offerte;
        }
        else {
            s.close();
            return null;
        }
    }


    @Override
    public Object findOff(String id) {
        Session s = DBResourcesManager.getSession();
        String query = "from OffertaEvento offertaEvento where offertaEvento.eveID = '"+id+"'";
        @SuppressWarnings("unchecked")
        List<OffertaEvento> offerte = s.createQuery(query).list();
        if(offerte.size()>0){
            s.close();
            return offerte.get(0);
        }
        else {
            s.close();
            return null;
        }
    }

    @Override
    public Object findtype(String type) {
        Session s = DBResourcesManager.getSession();
        String query = "from OffertaEvento offertaEvento where offertaEvento.toBuy = true and offertaEvento.tipologia = '"+type+"' order by offertaEvento.prezzo";
        @SuppressWarnings("unchecked")
        List<OffertaEvento> offerte = s.createQuery(query).setMaxResults(10).list();
        if(offerte.size()>0){
            s.close();
            return offerte;}
        else {
            s.close();
            return null;
        }
    }

    @Override
    public void modPrezzo(int eveID,int percent)
    {
        Session s = DBResourcesManager.getSession();
        int val;
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            OffertaEvento offertaEvento = (OffertaEvento)s.get(OffertaEvento.class,eveID);


            val = offertaEvento.getPrezzo();

            offertaEvento.setPrezzo(val + val*percent/100);
            s.update(offertaEvento);
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
        OffertaEvento offerta = (OffertaEvento) s.get(OffertaEvento.class , id);

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
    public Object customSearch(List<String> ls) {
        Session s = DBResourcesManager.getSession();
        String initquery = "from OffertaEvento offertaEvento";


        List<String> strings = new LinkedList<String>();

        if (!ls.isEmpty()) {
            initquery = initquery + " where offertaEvento.toBuy = true and ";
        }

        for (int i = 0; i < ls.size(); i++) {
            if (!ls.get(i).equals("") && i == 0)
                strings.add("offertaEvento.città = '" + ls.get(i) +"'");
                //sb.append(" offertaEvento.città = '").append(ls.get(i)).append("'");
            if (!ls.get(i).equals("") && i == 1) {
                try {
                    System.out.println(ls.get(i));
                    SimpleDateFormat format = new SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH);
                    java.util.Date parsed = format.parse(ls.get(i));
                    java.sql.Date newdate = new java.sql.Date(parsed.getTime());
                    strings.add("offertaEvento.dataScadenza < '" + newdate + "'");
                }
                catch(java.text.ParseException e){
                    System.out.println("Exception : ParseException");
                }
            }
            if (!ls.get(i).equals("") && i == 2)
                strings.add("offertaEvento.nome = '" + ls.get(i) + "'");
            if (!ls.get(i).equals("") && i == 3) {
                if(ls.get(i).equals("1"))
                    strings.add("offertaEvento.prezzo < '100'");
                if(ls.get(i).equals("2"))
                    strings.add("offertaEvento.prezzo > '100' && offertaEvento.prezzo < '500'");
                if(ls.get(i).equals("3"))
                    strings.add("offertaEvento.prezzo > '500'");
            }
            if (!ls.get(i).equals("") && i == 4)
                strings.add("offertaEvento.tipologia = '" + ls.get(i) + "'");
        }

        String joinedstring = String.join(" and ",strings);

        String query = initquery + joinedstring;
        List<OffertaEvento> offerte = s.createQuery(query).setMaxResults(10).list();
        if(offerte.size()>0){
            s.close();
            return offerte;}
        else {
            s.close();
            return null;
        }
    }
}
