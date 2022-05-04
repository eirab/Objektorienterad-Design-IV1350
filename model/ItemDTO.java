package model;

public class ItemDTO {

    private int identifier;
    private String name;
    private double price_excl_vat;
    private double total_excl_vat;
    private double total_incl_vat;
    private double vat_rate;
    private int quantity;
   private double  price_incl_vat;


    public ItemDTO(int identifier, String name, double price_excl_vat, double vat_rate) {
        this.identifier = identifier;
        this.name = name;
        this.price_excl_vat = price_excl_vat;

        this.total_excl_vat = 0;
        this.total_incl_vat = 0;
        this.vat_rate = vat_rate;
        this.quantity = 1;
    }

    public ItemDTO(){

    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice_excl_vat() {
        return price_excl_vat;
    }

    public void setPrice_excl_vat(double price_excl_vat) {
        this.price_excl_vat = price_excl_vat;
    }

    public double getVat_rate() {
        return vat_rate;
    }

    public void setVat_rate(double vat_rate) {
        this.vat_rate = vat_rate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;

    }


    public double getTotal_excl_vat() {
        return total_excl_vat;
    }

    public void setTotal_excl_vat(double total_excl_vat) {
        this.total_excl_vat = total_excl_vat;
    }

    public double getTotal_incl_vat() {
        return total_incl_vat;
    }

    public void setTotal_incl_vat(double total_incl_vat) {
        this.total_incl_vat = total_incl_vat;
    }

    public double getPrice_incl_vat() {
        return price_incl_vat;
    }

    public void setPrice_incl_vat(double price_incl_vat) {
        this.price_incl_vat = price_incl_vat;
    }
}
