package newpackage;

import newpackage.DAOFactory.DAOFactory;
import newpackage.EntityPackage.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by Alessandro on 03/02/2016.
 */
public class RegistrazioneController {

    private static RegistrazioneController instance;

    public static RegistrazioneController getInstance() {
        if (instance == null)
            instance = new RegistrazioneController();
        return instance;
    }

    private RegistrazioneController() {
    }

    public WebClient signUp(String nickname, String password, String name, String surname, String birthday){
        if(nickname == null || password == null || name == null || surname == null){
            return null;
        }

        try{
            DBResourcesManager.initHibernate();

            if(DAOFactory.getWebClientDAO().findSelectedUser(nickname,password)!=null){
                DBResourcesManager.shutdown();
                return null;
            }

            SimpleDateFormat format = new SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH);
            java.util.Date parsed = format.parse(birthday);
            Date newdate = new Date(parsed.getTime());

            WebClient webclient = new WebClient(nickname,password,name,surname,newdate);
            Carrello carrello = new Carrello();
            carrello.setHasEvent(new ArrayList<OffertaEvento>());
            carrello.setHasPacket(new ArrayList<Pacchetto>());
            carrello.setHasPer(new ArrayList<OffertaPernotto>());
            carrello.setHasTras(new ArrayList<OffertaTrasporto>());
            DAOFactory.getCarrelloDAO().store(carrello);

            webclient.setHasCart(carrello);
            webclient.setDataIscrizione(new Date((new java.util.Date()).getTime()));
            DAOFactory.getWebClientDAO().store(webclient);
            //DBResourcesManager.shutdown();
            return webclient;
        }
        catch (ParseException e){
            System.out.println("Errore nel formato della data\n");
            e.printStackTrace();
        }
        return null;
    }
}
