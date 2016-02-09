package newpackage.Enumerations;

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
