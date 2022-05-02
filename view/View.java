package view;

import controller.Controller;

import java.util.Scanner;

public class View {

    private Controller controller;



    public View(Controller controller){
        this.controller = controller;
        System.out.println("View initialised");
        menu();

    }


    public void menu(){
        System.out.println("-------------- HAROLD'S CORNER SHOP -------------");
        System.out.println("Press enter to start a new sale");
        addItem(3, 1);


    }


    /**
     * Adds the item to the current sale
     *
     */
    public void addItem(int itemIdentifier, int quantity){
        controller.addItem(itemIdentifier, quantity);


    }


    public void initialiseSale(){
        controller.initialiseSale();


    }

    public void endSale(){

    }


    public void sampleExcecution(){
        addItem(3, 1);

    }

}




