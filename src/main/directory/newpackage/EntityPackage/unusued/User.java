package newpackage.EntityPackage.unusued;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String usID;

    protected String Nome;

    public String getUsID(){
        return this.usID;
    }
    @Basic
    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    protected String Cognome;

    @Basic
    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    protected String password;

    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected User() {
        super();
    }

    public User(String usID, String ruolo){this.usID = usID; this.ruolo = ruolo;}

    @Basic
    protected String ruolo;

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

}