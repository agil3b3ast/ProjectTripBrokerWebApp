package newpackage;

/**
 * Created by Alessandro on 08/01/2016.
 */

public enum TipoOffertaPernotto {
    Hotel("Hotel"),
    BeB("B&B"),
    Appartamento("Appartamento"),
    CasaVacanze("Casa Vacanze");

    private String nome;

    TipoOffertaPernotto(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

}
