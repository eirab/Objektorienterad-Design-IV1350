package view;

import controller.Controller;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.EventListener;
import java.util.EventObject;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View {

    private Controller controller;



    public View(Controller controller) throws SQLException {
        this.controller = controller;
        controller.setView(this);
        sampleExecution();

    }








    public void setController(Controller controller){
        this.controller = controller;
    }

    /**
     * Adds the item to the current sale
     *
     */
    public void addItem(int itemIdentifier, int quantity) throws SQLException {
        controller.addItem(itemIdentifier, quantity);


    }


    public void initialiseSale() throws SQLException {
        System.out.println("Sale initialised");
        controller.initialiseSale();


    }

    public void endSale(double payment){
        controller.endSale(payment);

    }

    public void sampleExecution() throws SQLException {
        initialiseSale();
        addItem(3,2);
        addItem(3,1);
        addItem(5,1);
        controller.updateSaleView();
        double payment = 112.50;
        endSale(payment);

    }



}




