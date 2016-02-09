package newpackage.Beans;

import java.io.Serializable;
import java.util.ArrayList;

public class OffertaBean implements Serializable{
    protected String ofname;
    protected int ofprice;
    protected String ofdateexpired;
    protected ArrayList<OffertaBean> offerList;
    protected String ofcity;

    public OffertaBean(){
        this.ofname = "";
        this.ofdateexpired = "";
        this.ofcity = "";
    }

    public String getOfname(){return this.ofname;}
    public int getOfprice(){return this.ofprice;}
    public String getOfdateexpired(){return this.ofdateexpired;}
    public ArrayList<OffertaBean> getOfferList(){return this.offerList;}

    public void setOfname(String newofname){this.ofname = newofname;}
    public void setOfprice(int newofprice){this.ofprice = newofprice;}
    public void setOfdateexpired(String newofdateexpired){this.ofdateexpired = newofdateexpired;}
    public String getOfcity(){return this.ofcity;}
    public void setOfcity(String newcity){this.ofcity = newcity;}

}
