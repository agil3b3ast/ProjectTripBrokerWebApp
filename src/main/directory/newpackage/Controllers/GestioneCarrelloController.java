package newpackage.Controllers;

import newpackage.DAOFactory.DAOFactory;
import newpackage.DBResourcesManager;
import newpackage.EntityPackage.*;
import newpackage.Enumerations.TipoOfferta;

public class GestioneCarrelloController {
    private static GestioneCarrelloController instance;

    public static GestioneCarrelloController getInstance() {
        if (instance == null)
            instance = new GestioneCarrelloController();
        return instance;
    }

    private GestioneCarrelloController() {
    }

    public Object addItem(String iditem,String typeitem, String idcart){
        DBResourcesManager.initHibernate();
        if(typeitem.equals("Pacchetto")){
            Pacchetto p = DAOFactory.getPacchettoDAO().findByID(Integer.valueOf(iditem));

            if(p != null){
                Carrello c = DAOFactory.getCarrelloDAO().addToCart(idcart,p);

                if(c != null){
                    return p;
                }
            }
        }
        else if(typeitem.equals("OffertaEvento")){
            Object o = DAOFactory.getDAOFactory(TipoOfferta.OffertaEvento).getOffertaDAO().findOff(iditem);

            if(o != null){
                OffertaEvento of = (OffertaEvento) o;
                Carrello c = DAOFactory.getCarrelloDAO().addToCart(idcart,of);

                if(c != null){
                    return of;
                }
            }
        }
        else if(typeitem.equals("OffertaPernotto")){
            Object o = DAOFactory.getDAOFactory(TipoOfferta.OffertaPernotto).getOffertaDAO().findOff(iditem);

            if(o != null){
                OffertaPernotto of = (OffertaPernotto) o;
                Carrello c = DAOFactory.getCarrelloDAO().addToCart(idcart,of);

                if(c != null){
                    return of;
                }
            }
        }
        else if(typeitem.equals("OffertaTrasporto")){
            Object o = DAOFactory.getDAOFactory(TipoOfferta.OffertaTrasporto).getOffertaDAO().findOff(iditem);

            if(o != null){
                OffertaTrasporto of = (OffertaTrasporto) o;
                Carrello c = DAOFactory.getCarrelloDAO().addToCart(idcart,of);

                if(c != null){
                    return of;
                }
            }
        }
        return null;
    }
    public Object removeItem(String iditem,String typeitem, String idcart){
        DBResourcesManager.initHibernate();
        if(typeitem.equals("Pacchetto")){
            Pacchetto p = DAOFactory.getPacchettoDAO().findByID(Integer.valueOf(iditem));

            if(p != null){
                Carrello c = DAOFactory.getCarrelloDAO().removeFromCart(idcart,p);

                if(c != null){
                    return p;
                }
            }
        }
        else if(typeitem.equals("OffertaEvento")){
            Object o = DAOFactory.getDAOFactory(TipoOfferta.OffertaEvento).getOffertaDAO().findOff(iditem);

            if(o != null){
                OffertaEvento of = (OffertaEvento) o;
                Carrello c = DAOFactory.getCarrelloDAO().removeFromCart(idcart,of);

                if(c != null){
                    return of;
                }
            }
        }
        else if(typeitem.equals("OffertaPernotto")){
            Object o = DAOFactory.getDAOFactory(TipoOfferta.OffertaPernotto).getOffertaDAO().findOff(iditem);

            if(o != null){
                OffertaPernotto of = (OffertaPernotto) o;
                Carrello c = DAOFactory.getCarrelloDAO().removeFromCart(idcart,of);

                if(c != null){
                    return of;
                }
            }
        }
        else if(typeitem.equals("OffertaTrasporto")){
            Object o = DAOFactory.getDAOFactory(TipoOfferta.OffertaTrasporto).getOffertaDAO().findOff(iditem);

            if(o != null){
                OffertaTrasporto of = (OffertaTrasporto) o;
                Carrello c = DAOFactory.getCarrelloDAO().removeFromCart(idcart,of);

                if(c != null){
                    return of;
                }
            }
        }
        return null;
    }

}
