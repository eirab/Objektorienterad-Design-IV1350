package controller;

import model.AccountingSystem;
import integration.DBHandler;
import model.Inventory;
import model.ItemDTO;
import model.Sale;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private DBHandler dbhandler;
    private Sale sale;
    private Inventory inventory;
    private AccountingSystem accountingSystem;


    public Controller(DBHandler dbHandler, Inventory inventory, AccountingSystem accountingSystem) {
        this.dbhandler = dbHandler;
        this.inventory = inventory;
        this.accountingSystem = accountingSystem;


    }


    public void addItem(int itemIdentifier, int quantity) throws SQLException {
        this.sale.addItem(inventory.getItem(itemIdentifier));
        updateSaleView();


    }

    public void initialiseSale() {
        this.sale = new Sale();

    }


    public void updateSaleView() {
        ArrayList<ItemDTO>items = this.sale.getAddedItems();

            for (ItemDTO item : items) {
                System.out.println(item.getName());

            }


        }

    }
