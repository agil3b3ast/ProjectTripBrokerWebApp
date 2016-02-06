package newpackage;

import newpackage.EntityPackage.Carrello;
import newpackage.EntityPackage.WebClient;

import java.io.Serializable;

/**
 * Created by Alessandro on 29/01/2016.
 */
public class UtenteBean implements Serializable{
    private String nickname;
    private String password;
    private String name;
    private String surname;
    private boolean logged;
    private String birthday;
    private int id;
    private String avatar;
    private CarrelloBean carrelloBean;
    private String signUpDate;

    public UtenteBean(){
        this.nickname = "";
        this.password = "";
        this.name = "";
        this.surname = "";
        this.logged = false;
        this.birthday = "";
        this.carrelloBean = null;
        this.avatar = Avatars.WebClient.getPath();
        this.signUpDate = "";
    }

    public CarrelloBean getCarrelloBean() {
        return this.carrelloBean;
    }

    public void setCarrelloBean(CarrelloBean carrelloBean) {
        this.carrelloBean = carrelloBean;
    }

    public String getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(String signUpDate) {
        this.signUpDate = signUpDate;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean signUp() {
        if(this.nickname == null || this.password == null || this.name == null || this.surname == null){
            return false;
        }

        RegistrazioneController registrazioneController = RegistrazioneController.getInstance();
        WebClient webClient =  registrazioneController.signUp(this.nickname,this.password,this.name,this.surname,this.birthday);
        if(webClient == null){
            this.logged = false;
            return false;
        }
        this.signUpDate = webClient.getDataIscrizione().toString();
        this.carrelloBean = buildFromEntity(webClient.getHasCart());
        this.logged = true;
        return true;
    }

    public CarrelloBean buildFromEntity(Carrello carrello){
        CarrelloBean cb = new CarrelloBean();
        cb.setUtenteBean(this);
        return cb;
    }

    public boolean logIn(){
        if(this.nickname == null || this.password == null){
            return false;
        }
        LoginController loginController = LoginController.getInstance();
        WebClient webClient = loginController.login(this.nickname,this.password);
        if(webClient == null) {
            this.logged = false;
        }
        else {
            this.name = webClient.getNome();
            this.surname = webClient.getCognome();
            this.birthday = webClient.getBirthday().toString();
            this.signUpDate = webClient.getDataIscrizione().toString();
            this.id = webClient.getId();
            this.carrelloBean = buildFromEntity(webClient.getHasCart());
            this.logged = true;
        }
        return this.logged;
    }
}
