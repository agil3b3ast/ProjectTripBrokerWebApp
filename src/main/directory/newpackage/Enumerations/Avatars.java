package newpackage.Enumerations;

import newpackage.EntityPackage.OffertaEvento;

public enum Avatars{

    WebClient("C:\\Users\\Alessandro\\Downloads\\Annotations, Hibernate e JPA\\MyFirstWebApp\\src\\main\\webapp\\biffyclyro.jpeg"),
    Packet("packet.jpg"),
    Evento("evento.jpg"),
    Pernotto("pernotto.jpg"),
    Trasporto("trasporto.jpg");
    private String path;

    Avatars(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
