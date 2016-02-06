package newpackage;

import newpackage.EntityPackage.Carrello;
import sun.security.util.Password;

import java.sql.Date;

public class Utente {

    private String nickname;
    private Password password;
    private String name;
    private String surname;
    private Date birthday;
    private int id;
    private String avatar;
    private Carrello cart;

    public Utente(String nickname,Password password) {

    }
}
