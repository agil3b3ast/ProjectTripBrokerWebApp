package newpackage.DAOFactory;

import newpackage.DAO.OffertaDAO;
import newpackage.DAO.OffertaPernottoDAO;


public class OffertaPernottoDAOImpl extends DAOFactory {



    public  OffertaDAO getOffertaDAO(){

        return new OffertaPernottoDAO();
    }


}
