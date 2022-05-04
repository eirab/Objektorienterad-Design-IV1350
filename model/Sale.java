package model;

import integration.DBHandler;


import javax.print.DocFlavor;
import java.util.ArrayList;


public class Sale {

private Inventory inventory;
private AccountingSystem accountingSystem;
private SaleDTO currentSale;





public Sale(AccountingSystem acc, Inventory in){

    this.inventory = in;
    this.accountingSystem = acc;
this.currentSale = new SaleDTO();



}

public void addItem(ItemDTO item, int quantity){
    if(quantity > 0){
        item.setQuantity(quantity);
        addVATtoItem(item);
        updateItemTotal(item, quantity);
        updateRunningTotal(item, quantity);
        this.currentSale.getItems().add(item);
    }
    else{
        System.out.println("Error: can't add item with a quantity less than 0");
    }


}

public ArrayList<ItemDTO> getAddedItems(){
    return this.currentSale.getItems();
}

public void updateItemTotal(ItemDTO item, int quantity){

    /* Update price excluding VAT */
    double price_excl_vat = item.getPrice_excl_vat();
    item.setTotal_excl_vat(item.getTotal_excl_vat() + (price_excl_vat * quantity));

    /* Update price including VAT */
    double price_incl_vat = item.getPrice_incl_vat();
    item.setTotal_incl_vat(item.getTotal_incl_vat() + (price_incl_vat * quantity));




}



public boolean itemAlreadyAdded(int itemIdentifier){
    ArrayList<ItemDTO> addedItems = currentSale.getItems();
    for(ItemDTO item : addedItems){
        if(item.getIdentifier() == itemIdentifier){
            return true;
        }
    }
    return false;
}

public void endSale(){


}



private void addVATtoItem(ItemDTO item){
    item.setPrice_incl_vat(item.getPrice_excl_vat() * ((item.getVat_rate()/100)+1));



}

private void updateRunningTotal(ItemDTO item, int quantity){

    /* Update total excluding VAT */
    double total_excl_vat = this.currentSale.getTotal_excl_vat();
    this.currentSale.setTotal_excl_vat(total_excl_vat + (item.getPrice_excl_vat() * quantity));

    /* Update total including VAT */
    double total_incl_vat = this.currentSale.getTotal_incl_vat();
    this.currentSale.setTotal_incl_vat(total_incl_vat + (item.getPrice_incl_vat() * quantity));


    }


public void addVAT(){

}

    public SaleDTO getCurrentSale() {
        return currentSale;
    }

    public void setCurrentSale(SaleDTO currentSale) {
        this.currentSale = currentSale;
    }


    public void increaseQuantity(ItemDTO item, int quantity){
    item.setQuantity(item.getQuantity()+quantity);
    updateItemTotal(item, quantity);
    updateRunningTotal(item, quantity);
    }




    public ItemDTO getAddedItem(int itemIdentifier){
            ArrayList<ItemDTO> addedItems = getAddedItems();
            ItemDTO item = null;
            for(ItemDTO currentItem: addedItems){
                if(currentItem.getIdentifier() == itemIdentifier){
                    item = currentItem;
                }
            }
            return item;
        }



}
