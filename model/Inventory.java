package model;


import integration.DBHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Inventory {
    private final String items = "items";
    private final String GET_ITEM_BY_IDENTIFIER = "SELECT* FROM items WHERE identifier = ";
    private final String CHECK_IDENTIFIER = "SELECT COUNT(*) AS recordCount FROM items WHERE identifier = ";
    private DBHandler dbHandler;
    private ItemDTO itemDTO;



    public Inventory(DBHandler db) {
        this.dbHandler = db;



    }

   public ItemDTO getItem ( int identifier) throws SQLException {
        ItemDTO currentItem = getItemDTO(getItemFromDatabase(identifier));
        return currentItem;
   }

   public boolean identifierExists(int identifier) throws SQLException {
        ResultSet resultSet = executeQuery(CHECK_IDENTIFIER + identifier);
        resultSet.next();
        int count = resultSet.getInt("recordCount");
        if(count == 0){
            return false;
        }else return true;

   }

   private ResultSet executeQuery(String query) {
       ResultSet result = null;

       try {
           Connection connection = dbHandler.connect();
           Statement statement = connection.createStatement();
           result = statement.executeQuery(query);
           connection.close();
           return result;

       } catch (Exception e) {

       }
       return result;
    }



    private ResultSet getItemFromDatabase(int itemIdentifier)  {
         return executeQuery( GET_ITEM_BY_IDENTIFIER + itemIdentifier);

    }


    private ItemDTO getItemDTO(ResultSet itemRow) throws SQLException {
        ItemDTO item = new ItemDTO();
        while (itemRow.next()) {
            item.setIdentifier(itemRow.getInt("identifier"));
            item.setName(itemRow.getString("name"));
            item.setPrice_excl_vat(itemRow.getDouble("price_excl_vat"));
            item.setVat_rate(itemRow.getDouble("vat_rate"));

        }
        itemRow.close();
        return item;


    }




}
