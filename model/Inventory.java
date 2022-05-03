package model;


import integration.DBHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Inventory {
    private final String items = "items";
    private final String GET_ITEM_BY_IDENTIFIER = "SELECT* FROM items WHERE identifier = ";
    private DBHandler dbHandler;
    private ItemDTO itemDTO;


    public Inventory(DBHandler dbHandler) {
        this.dbHandler = dbHandler;


    }


    public ItemDTO getItem(int itemIdentifier) throws SQLException {
        String query = GET_ITEM_BY_IDENTIFIER + itemIdentifier;
        ResultSet result;

        try {
            Connection connection = dbHandler.connect();
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            return createDTO(result);



        } catch (Exception e) {

            throw new RuntimeException(e);
        }


    }


    private ItemDTO createDTO(ResultSet itemRow) throws SQLException {
        ItemDTO item = new ItemDTO();
        while (itemRow.next()) {
            item.setIdentifier(itemRow.getInt("identifier"));
            item.setName(itemRow.getString("name"));
            item.setPrice_excl_vat(itemRow.getDouble("price_excl_vat"));
            item.setVat_rate(itemRow.getDouble("vat_rate"));
            item.setStock(itemRow.getInt("stock"));

        }

        return item;


    }


}
