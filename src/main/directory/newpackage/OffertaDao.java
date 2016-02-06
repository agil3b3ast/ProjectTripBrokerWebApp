package newpackage;

import newpackage.EntityPackage.Offerta;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Alessandro on 30/12/2015.
 */
public class OffertaDao {

    private static String DB_URL = "jdbc:mysql://localhost:3306/myfirsthibernatedb?user=newuser&password=MYL841f8";

    public static ArrayList<Offerta> findAll(String typetable, String typesearch) {
        // STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = null;
        ArrayList<Offerta> u = new ArrayList<Offerta>();
        try {
            // STEP 2: loading dinamico del driver mysql
            Class.forName("com.mysql.jdbc.Driver");

            // STEP 3: apertura connessione
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirsthibernatedb?user=newuser&password=MYL841f8");

            // STEP 4: creazione ed esecuzione della query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM "+typetable+" as tt WHERE tt.tipologia = '"+typesearch+"';";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            int columnCount = rs.getMetaData().getColumnCount();
            Offerta of;

            while(rs.next())
            {
                //String[] row = new String[columnCount];
                of = new Offerta();
                //for (int i=0; i <columnCount ; i++)
                //{

                //of.setOfprice(rs.getString("prezzo"));
                //of.setOfdateexpired(rs.getString("dataScadenza"));
                //of.setOfname(rs.getString("nome"));
                //of.setOftype(rs.getString("tipologia"));
                //}
                u.add(of);
            }

        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

        }
        return u;
    }
}
