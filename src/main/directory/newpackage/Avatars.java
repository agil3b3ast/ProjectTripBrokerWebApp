package newpackage;

/**
 * Created by Alessandro on 03/02/2016.
 */
public enum Avatars{

    WebClient("C:\\Users\\Alessandro\\Downloads\\Annotations, Hibernate e JPA\\MyFirstWebApp\\src\\main\\webapp\\biffyclyro.jpeg");

    private String path;

    Avatars(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
