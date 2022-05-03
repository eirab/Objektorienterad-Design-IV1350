package model;

public class ItemDTO {

    private int identifier;
    private String name;
    private double price_excl_vat;
    private double vat_rate;
    private int stock;

    public ItemDTO(int identifier, String name, double price_excl_vat, double vat_rate, int stock) {
        this.identifier = identifier;
        this.name = name;
        this.price_excl_vat = price_excl_vat;
        this.vat_rate = vat_rate;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
