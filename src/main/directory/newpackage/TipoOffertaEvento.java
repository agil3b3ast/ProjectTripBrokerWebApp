package newpackage;

/**
 * Created by Alessandro on 08/01/2016.
 */
public enum TipoOffertaEvento {
    Museo("Museo"),
    Concerto("Concerto"),
    VisitaGuidata("Visita guidata"),
    Cinema("Cinema"),
    Teatro("Teatro");

    private String nome;

    TipoOffertaEvento(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
}

