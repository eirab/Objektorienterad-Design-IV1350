package controller;

import model.AccountingSystem;
import integration.DBHandler;
import model.Inventory;
import model.ItemDTO;
import model.Sale;
import view.View;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {

    private DBHandler dbhandler;
    private View view;
    private Sale sale;
    private Inventory inventory;
    private AccountingSystem accountingSystem;


    public Controller() {
        this.dbhandler = new DBHandler();
        this.inventory = new Inventory(this.dbhandler);
        this.accountingSystem = new AccountingSystem(this.dbhandler);


    }

    /**
     * This method clear the current screen
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void addItem(int itemIdentifier, int quantity) throws SQLException {
        ItemDTO currentItem = null;

        if (this.inventory.identifierExists(itemIdentifier)) {


            if (this.sale.itemAlreadyAdded(itemIdentifier)) {
                currentItem = this.sale.getAddedItem(itemIdentifier);
                this.sale.increaseQuantity(currentItem, quantity);

            } else {
                currentItem = this.inventory.getItem(itemIdentifier);
                currentItem.setQuantity(quantity);
                this.sale.addItem(currentItem, quantity);

            }

        }


    }

    public void setView(View view) {
        this.view = view;
    }

    public void initialiseSale() {
        this.sale = new Sale(this.accountingSystem, this.inventory);

    }

    public void updateSaleView() {
        clearScreen();

        System.out.println("-----------------------------------------------------");

        ArrayList<ItemDTO> addedItems = this.sale.getAddedItems();
        for (ItemDTO item : addedItems) {
            System.out.printf("%-30s %3s %.2f %3s %5s",
                    "|" + item.getName().trim(),
                    ("x" + item.getQuantity()),
                    item.getTotal_incl_vat(),
                    "  (VAT", item.getVat_rate() + "%)" + "\n");
        }
        System.out.println("-----------------------------------------------------");
        System.out.printf("%50s %.2f", "Running total (incl VAT)", this.sale.getCurrentSale().getTotal_incl_vat());
        System.out.println();


    }

    public void endSale(double payment) {

        System.out.printf("\n %10s %.2f", "Amount to pay:", this.sale.getCurrentSale().getTotal_incl_vat());
        System.out.printf("\n %10s %.2f", "Amount paid:", payment);

    }

    public void enterCashPayment(double amount) {


    }
}


