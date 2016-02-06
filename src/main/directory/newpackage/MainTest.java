package newpackage;

import newpackage.EntityPackage.Offerta;
import newpackage.EntityPackage.OffertaEvento;
import newpackage.EntityPackage.OffertaPernotto;
import newpackage.EntityPackage.OffertaTrasporto;

import java.lang.reflect.Method;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Alessandro on 08/01/2016.
 */
public class MainTest {

    public static void main(String[] args) {
        //DBResourcesManager.initHibernate();

        OffertaEvento of = new OffertaEvento();
        of.setNome("ofevent");
        of.setTipologia("Concerto");
        of.setPrezzo(69);
        //of.setDataScadenza("21/08/2019");
        of.setCittà("Roma");

        Offerta offertaArray[] = {new OffertaEvento(),new OffertaPernotto(),new OffertaTrasporto()};
        /*
        for(Offerta o : offertaArray) {
            System.out.println(o.getClass().getSimpleName() + "\n");
            Method[] methods = o.getClass().getMethods();
            for (Method m : methods) {
                int l = m.getName().length();
                if (m.getName().substring(0, 3).equals("set") && !m.getName().substring(l - 2, l).equals("ID"))
                    System.out.println(m.getName());
            }
        }*/
        /*
        OffertaBean object = new OffertaEventoBean();


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
        }*/
        String città = "Roma";
        String dataScadenza = "11/07/2009";
        String nome = "Bubu";
        String prezzo = "4";
        String tipologia = "Museo";

        String query = "from OffertaEvento offertaEvento";

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

        System.out.println(query);


        ArrayList<String> ls = new ArrayList<String>();
        ls.add(città);
        ls.add(dataScadenza);
        ls.add(nome);
        ls.add(prezzo);
        ls.add(tipologia);
        System.out.println("\nNuova query\n");

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
        }

        System.out.println(query);

        Offerta o = new OffertaEvento();

        List<Method> fields= Arrays.asList(o.getClass().getDeclaredMethods());

        Class c = o.getClass().getSuperclass();

        List<Method> superfields = Arrays.asList(c.getDeclaredMethods());

        List<Method> allfields = new ArrayList<Method>(fields);
        allfields.addAll(superfields);

        allfields.sort(new Comparator<Method>() {
            public int compare(Method o1, Method o2) {
                return o1.getName().compareTo(o1.getName());
            }
        });
        /*
        for(Method f: allfields){

        }*/
        Date date = Date.valueOf(LocalDate.now());
        System.out.println(date);
        String datestring = date.toString();
        System.out.println(datestring);
        Date data2 = Date.valueOf(datestring);
        System.out.println(data2);
        //OffertaEventoDAO.store(of);

        //System.out.println(((List<OffertaEvento>)DAOFactory.getDAOFactory(TipoOfferta.OffertaEvento).getOffertaDAO().getList()).size());

        //DBResourcesManager.shutdown();

        //OffertaDaoAnnotations.findAllOffertaEntitysA("offertaevento","Concerto");
    }
}
