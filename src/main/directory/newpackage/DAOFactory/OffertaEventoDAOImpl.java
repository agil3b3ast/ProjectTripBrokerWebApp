package newpackage.DAOFactory;

import newpackage.DAO.OffertaDAO;
import newpackage.DAO.OffertaEventoDAO;


public class OffertaEventoDAOImpl extends DAOFactory {

    public OffertaDAO getOffertaDAO(){

        return new OffertaEventoDAO();
    }


}