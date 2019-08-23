/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.grocery.app.dbAccess;

import com.grocery.app.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.grocery.app.model.Item;

/**
 *
 * @author HaShaN
 */
public class ItemDBAccess{
    private static ResultSet rst;
    
    public boolean addItem(Item item) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement("insert into Item values(?,?,?,?)");
        stm.setObject(1, item.getCode());
        stm.setObject(2, item.getDescription());
        stm.setObject(3, item.getQty());
        stm.setObject(4, item.getUnitPrice());
        return stm.executeUpdate()>0;
    }
    
    
    public boolean deleteItem(String code) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate("Delete from Item where ItemCode='" + code + "'")>0;
    }
    
    
    public boolean updateItem(Item item) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement("Update Item set Description=?, QtyOnHand=?, UnitPrice=? where ItemCode=?");
        stm.setObject(1, item.getDescription());
        stm.setObject(2, item.getQty());
        stm.setObject(3, item.getUnitPrice());
        stm.setObject(4, item.getCode());
        return stm.executeUpdate()>0;
    }
    
    public int updateItemQTY(String icode,int qty) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement("Update Item set QtyOnHand=? where ItemCode=?");
        stm.setObject(1, qty);
        stm.setObject(2, icode);
        return stm.executeUpdate();
    }
    
    
    public Item searchItem(String code) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        rst = stm.executeQuery("Select * From Item where ItemCode='" + code + "'");
        if (rst.next()) {
            return new Item(rst.getString("ItemCode"), rst.getString("Description"), rst.getInt("QtyOnHand"), rst.getDouble("UnitPrice"));
        } else {
            return null;
        }
    }
    
    
    public ArrayList<Item> getAllItems() throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        rst = stm.executeQuery("Select * from Item");
        ArrayList<Item> itemList = new ArrayList<>();
        while (rst.next()) {
            itemList.add(new Item(rst.getString("ItemCode"), rst.getString("Description"), rst.getInt("QtyOnHand"), rst.getDouble("UnitPrice")));
        }
        return itemList;
    }
    
}
