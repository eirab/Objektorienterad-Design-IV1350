package model;

import org.postgresql.util.PGTimestamp;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class SaleDTO {


   private double total;
   private double payment_amount;
   private boolean active;
   private double cash_payment_amount;
   private double total_excl_vat;
   private double total_incl_vat;
   private double change_amount;
   private ArrayList<ItemDTO> items;


    public SaleDTO() {

        this.payment_amount = 0;
        this.active = true;
        this.items = new ArrayList<>();
        this.cash_payment_amount = 0;
        this.total_excl_vat = 0;
        this.total_incl_vat = 0;
        this.change_amount = 0;

    }



    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(double payment_amount) {
        this.payment_amount = payment_amount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<ItemDTO> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemDTO> items) {
        this.items = items;
    }

    public double getCash_payment_amount() {
        return cash_payment_amount;
    }

    public void setCash_payment_amount(double cash_payment_amount) {
        this.cash_payment_amount = cash_payment_amount;
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

    public double getChange_amount() {
        return change_amount;
    }

    public void setChange_amount(double change_amount) {
        this.change_amount = change_amount;
    }
}
