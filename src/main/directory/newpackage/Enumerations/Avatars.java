package newpackage.Enumerations;

import newpackage.EntityPackage.OffertaEvento;

/**
 * Created by Alessandro on 03/02/2016.
 */
public enum Avatars{

    WebClient("C:\\Users\\Alessandro\\Downloads\\Annotations, Hibernate e JPA\\MyFirstWebApp\\src\\main\\webapp\\biffyclyro.jpeg"),
    Packet("C:\\Users\\Alessandro\\Documents\\ProgettoTripBroker\\ProjectTripBrokerWebApp\\web\\random_points.jpg"),
    Evento("C:\\Users\\Alessandro\\Documents\\ProgettoTripBroker\\ProjectTripBrokerWebApp\\web\\evento.jpg"),
    Pernotto("C:\\Users\\Alessandro\\Documents\\ProgettoTripBroker\\ProjectTripBrokerWebApp\\web\\pernotto.jpg"),
    Trasporto("C:\\Users\\Alessandro\\Documents\\ProgettoTripBroker\\ProjectTripBrokerWebApp\\web\\trasporto.jpg");
    private String path;

    Avatars(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
