/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.grocery.app.controller.impl;

import com.grocery.app.controller.ItemController;
import com.grocery.app.dbAccess.ItemDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import com.grocery.app.model.Item;

/**
 *
 * @author HaShaN
 */
public class ItemControllerImpl implements ItemController{
    private final ItemDBAccess itemDBAccess=new ItemDBAccess();
    public ItemControllerImpl(){}
    
    @Override
    public boolean addItem(Item item) throws ClassNotFoundException, SQLException {
        return itemDBAccess.addItem(item);
    }
    
    @Override
    public boolean deleteItem(String code) throws ClassNotFoundException, SQLException {
        return itemDBAccess.deleteItem(code);
    }
    
    @Override
    public boolean updateItem(Item item) throws ClassNotFoundException, SQLException {
        return itemDBAccess.updateItem(item);
    }
    
    @Override
    public Item searchItem(String code) throws ClassNotFoundException, SQLException {
        return itemDBAccess.searchItem(code);
    }
    
    @Override
    public ArrayList<Item> getAllItems() throws ClassNotFoundException, SQLException {
        return itemDBAccess.getAllItems();
    }
    
    @Override
    public int updateItemQTY(String icode, int qty) throws ClassNotFoundException, SQLException {
        return itemDBAccess.updateItemQTY(icode, qty);
    }
    
}
