package newpackage.Enumerations;

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
