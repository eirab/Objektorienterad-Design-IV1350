package startup;

import controller.Controller;
import view.View;

import java.sql.*;


public class Main {


    public static void main(String[] args) throws SQLException {
        System.out.println("Initialising program");
        Controller controller = new Controller();
        System.out.println("Controller initialised");
        View view = new View(controller);



    }


}