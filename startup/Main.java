package startup;

import controller.Controller;
import integration.DBHandler;
import model.AccountingSystem;
import model.Inventory;
import view.View;

import java.sql.*;
import java.util.AbstractCollection;


public class Main {


    public static void main(String[] args) throws SQLException {
        System.out.println("Initialising program");
        DBHandler dbHandler = new DBHandler();
        Inventory inventory = new Inventory(dbHandler);
        AccountingSystem accountingSystem = new AccountingSystem(dbHandler);
        Controller controller = new Controller(dbHandler, inventory, accountingSystem);
        System.out.println("Controller initialised");
        View view = new View(controller);



    }


}