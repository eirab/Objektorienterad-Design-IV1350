package controller;

import integration.DBHandler;
import model.Sale;

public class Controller {

    private DBHandler dbhandler;
    private Sale sale;



    public Controller(){



    }


    public void addItem(int itemIdentifier, int quantity) {
        DBHandler dbHandler = new DBHandler();
        dbHandler.connect();

    }

    public void initialiseSale() {
        System.out.println("Sale initialised");

    }
}
