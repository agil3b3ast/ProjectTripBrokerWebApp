package newpackage.DAOFactory;

import newpackage.DAO.OffertaDAO;
import newpackage.DAO.OffertaTrasportoDAO;


public class OffertaTrasportoDAOImpl extends DAOFactory {

    public OffertaDAO getOffertaDAO(){

        return new OffertaTrasportoDAO();
    }


}