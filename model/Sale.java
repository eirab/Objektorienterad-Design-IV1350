package model;

import integration.DBHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Sale {

private DBHandler dbHandler;

private ArrayList<ItemDTO> addedItems;

public Sale(){

this.addedItems = new ArrayList<ItemDTO>();


}

public void addItem(ItemDTO item){
  this.addedItems.add(item);
}

public ArrayList<ItemDTO> getAddedItems(){
    return this.addedItems;
}


}
