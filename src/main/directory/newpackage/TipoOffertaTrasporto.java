package newpackage;

/**
 * Created by Alessandro on 08/01/2016.
 */
public enum TipoOffertaTrasporto {
    Treno("Treno"),
    Aereo("Aereo"),
    Nave("Nave"),
    Autobus("Autobus");

    private String nome;

    TipoOffertaTrasporto(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
}
