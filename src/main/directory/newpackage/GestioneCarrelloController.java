package newpackage;

import newpackage.EntityPackage.Pacchetto;

/**
 * Created by Alessandro on 04/02/2016.
 */
public class GestioneCarrelloController {
    private static GestioneCarrelloController instance;

    public static GestioneCarrelloController getInstance() {
        if (instance == null)
            instance = new GestioneCarrelloController();
        return instance;
    }

    private GestioneCarrelloController() {
    }

    public boolean addItem(String iditem,String typeitem){
        if(typeitem == "Pacchetto") {
            PacchettoController pc = PacchettoController.getInstance();
            Pacchetto p = pc.findByID(iditem);
            /*
            if(p != null){
                for(Object object : this.itemList){
                    //if(pack.getId().equals(p.getId())){
                    if(object instanceof PacchettoBean){
                        if(((PacchettoBean)object).getId() ==  p.getId()) {
                            this.packetitem = "";
                            return false;
                        }
                    }
                }
            }*/
        }
        return false;
    }
}
