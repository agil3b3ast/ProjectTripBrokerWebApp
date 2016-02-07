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

/**
 * Created by Simone on 16/12/2015.
 */
public class OffertaEventoDAO extends OffertaDAO {

    @Override
    public  Object getList() {

        Session s = DBResourcesManager.getSession();

        String query = "from OffertaEvento offertaEvento where offertaEvento.toBuy = true";
        @SuppressWarnings("unchecked")
        List<OffertaEvento> offerte = s.createQuery(query).list();
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
        String query = "from OffertaEvento offertaEvento where offertaEvento.toBuy = true and offertaEvento.tipologia = '"+type+"'";
        @SuppressWarnings("unchecked")
        List<OffertaEvento> offerte = s.createQuery(query).list();
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
        /*
        catch (EJBTransactionRolledbackException e) {
            Throwable t = e.getCause();
            while ((t != null) && !(t instanceof ConstraintViolationException)) {
                t = t.getCause();
            }
            if (t instanceof ConstraintViolationException) {
                System.out.println("Offerta non rimovibile, presente in un pacchetto");
                throw e;
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

    @Override
    public Object customSearch(List<String> ls) {
        Session s = DBResourcesManager.getSession();
        String initquery = "from OffertaEvento offertaEvento";

        /*
        String query = "from OffertaEvento offertaEvento";
        if(città == null && dataScadenza == null && nome == null && prezzo == null && tipologia == null){
            @SuppressWarnings("unchecked")
            List<OffertaEvento> offerte = s.createQuery(query).list();
            if(offerte.size()>0)
                return offerte;
            else
                return null;
        }
        query = query + " where ";
        if(città != null)
            query = query + "offertaEvento.città = '"+città+"' && ";
        if(dataScadenza != null)
            query = query + "offertaEvento.dataScadenza = '" + dataScadenza + "' && ";
        if(nome != null)
            query = query + "offertaEvento.nome = '"+nome+"' && ";
        if(prezzo != null)
            query = query + "offertaEvento.prezzo = '"+prezzo+"' && ";
        if(tipologia != null)
            query = query + "offertaEvento.tipologia = '"+tipologia+"'";

        @SuppressWarnings("unchecked")
        List<OffertaEvento> offerte = s.createQuery(query).list();
        if(offerte.size()>0)
            return offerte;
        else
            return null;*/
        //StringBuilder sb = new StringBuilder(14);
        List<String> strings = new LinkedList<String>();

        if (!ls.isEmpty()) {
            //sb.append(initquery).append(" where");
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
                //sb.append(" offertaEvento.dataScadenza = '").append(ls.get(i)).append("'");
            }
            //sb.append(" offertaEvento.dataScadenza = '").append(ls.get(i)).append("'");
            if (!ls.get(i).equals("") && i == 2)
                strings.add("offertaEvento.nome = '" + ls.get(i) + "'");
                //sb.append(" offertaEvento.nome = '").append(ls.get(i)).append("'");
            if (!ls.get(i).equals("") && i == 3) {
                if(ls.get(i).equals("1"))
                    strings.add("offertaEvento.prezzo < '100'");
                    //sb.append(" offertaEvento.prezzo < '100'");
                if(ls.get(i).equals("2"))
                    strings.add("offertaEvento.prezzo > '100' && offertaEvento.prezzo < '500'");
                    //sb.append(" offertaEvento.prezzo > '100' && offertaEvento.prezzo < '500'");
                if(ls.get(i).equals("3"))
                    strings.add("offertaEvento.prezzo > '500'");
                //sb.append(" offertaEvento.prezzo > '500'");
            }
            if (!ls.get(i).equals("") && i == 4)
                strings.add("offertaEvento.tipologia = '" + ls.get(i) + "'");
            //sb.append(" offertaEvento.tipologia = '").append(ls.get(i)).append("'");
        }

        String joinedstring = String.join(" and ",strings);
        System.out.println(initquery + joinedstring);
        /*
        if(!ls.isEmpty())
            query.join(" where");

        for(int i= 0; i<ls.size();i++){
            if(!ls.get(i).equals("") && i == 0)
                query.join(" && offertaEvento.città = '"+ls.get(i)+"'");
            if(!ls.get(i).equals("") && i == 1)
                query.join(" && offertaEvento.dataScadenza = '"+ls.get(i)+"'");
            if(!ls.get(i).equals("") && i == 2)
                query.join(" && offertaEvento.nome = '"+ls.get(i)+"'");
            if(!ls.get(i).equals("") && i == 3)
                query.join(" && offertaEvento.prezzo = '"+ls.get(i)+"'");
            if(!ls.get(i).equals("") && i == 4)
                query.join(" && offertaEvento.tipologia = '"+ls.get(i)+"'");
        }*/

        //System.out.println(sb.toString());
        //return new Object();
        String query = initquery + joinedstring;
        List<OffertaEvento> offerte = s.createQuery(query).list();
        if(offerte.size()>0){
            s.close();
            return offerte;}
        else {
            s.close();
            return null;
        }
    }
}
