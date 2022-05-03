package view;

import controller.Controller;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.Scanner;

public class View {

    private Controller controller;



    public View(Controller controller) throws SQLException {
        this.controller = controller;
        System.out.println("View initialised");
        initialiseSale();
        addItem(3, 1);
        addItem(4,1);
        addItem(5, 1);
    }




    /**
     * Adds the item to the current sale
     *
     */
    public void addItem(int itemIdentifier, int quantity) throws SQLException {
        controller.addItem(itemIdentifier, quantity);


    }


    public void initialiseSale(){
        controller.initialiseSale();


    }

    public void endSale(){

    }

    public void updateCurrentSale(ItemDTO[] items){



    }




}




