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

        Controller controller = new Controller();
        View view = new View(controller);


    }


}