package newpackage;

import java.sql.*;
import java.util.ArrayList;

public class UtendeDao {
    private static String PASS = "745123";
    private static String USER = "root";
    private static String DB_URL = "jdbc:mysql://localhost:3306/myfirsthibernatedb?user=newuser&password=MYL841f8";

    public static ArrayList<String[]> findAll() {
        // STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = null;
        ArrayList<String[]> u = new ArrayList<String[]>();
        try {
            // STEP 2: loading dinamico del driver mysql
            Class.forName("com.mysql.jdbc.Driver");

            // STEP 3: apertura connessione
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirsthibernatedb?user=newuser&password=MYL841f8");

            // STEP 4: creazione ed esecuzione della query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(sql);

            int columnCount = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                String[] row = new String[columnCount];
                for (int i=0; i <columnCount ; i++)
                {
                    row[i] = rs.getString(i+1);
                }
                u.add(row);
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




    public static Utente findByNameAndPassword(String username, String password) {
        // STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = null;
        Utente u = null;
        try {
            // STEP 2: loading dinamico del driver mysql
            Class.forName("com.mysql.jdbc.Driver");

            // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 4: creazione ed esecuzione della query
            stmt = conn.createStatement();
            String sql = "SELECT nome, username, password FROM utenti where username = '"
                    + username + "' AND password = '" + password + "';";
            ResultSet rs = stmt.executeQuery(sql);

            if (!rs.first()) // rs not empty
                return null;

            boolean moreThanOne = rs.first() && rs.next();
            assert !moreThanOne; // per abilitare le asserzioni, avviare la JVM con il parametro -ea
            // (Run Configurations -> <configurazione utilizzata per l'avvio del server> -> Arguments -> VM Arguments).
            // N.B. Le asserzioni andrebbero usate solo per test e debug, non per codice in produzione

            // riposizionamento del cursore
            rs.first();

            // lettura delle colonne "by name"
            String nome = rs.getString("nome");
            String cognome = rs.getString("cognome");
            String usernameLoaded = rs.getString("username");

            assert (usernameLoaded.equals(username));

            //u = new Utente(usernameLoaded, "", nome, cognome);

            // STEP 6: Clean-up dell'ambiente
            rs.close();
            stmt.close();
            conn.close();
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

    public static Utente findByNameAndPasswordMockup(String username, String password) {
        if ("myusername".equals(username) && "mypassword".equals(password))
            //return new Utente("myusername", "", "Tizio","Caio");
                return null;
        //else return null;
        return null;
    }
}
