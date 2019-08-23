/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.grocery.app.controller.impl;

import com.grocery.app.controller.OrderController;
import com.grocery.app.dbAccess.OrderDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import com.grocery.app.model.Order;

/**
 *
 * @author HaShaN
 */
public class OrderControllerImpl implements OrderController{
    private final OrderDBAccess orderDBAccess=new OrderDBAccess();
    public OrderControllerImpl(){}
    
    @Override
    public boolean addOrder(Order order) throws ClassNotFoundException, SQLException {
        return orderDBAccess.addOrder(order);
    }
    
    @Override
    public Order searchOrder(String oid) throws ClassNotFoundException, SQLException {
        return orderDBAccess.searchOrder(oid);
    }
    
    @Override
    public boolean deleteOrder(String oid) throws ClassNotFoundException, SQLException {
        return orderDBAccess.deleteOrder(oid);
    }
    
    @Override
    public ArrayList<Order> getAllOrders() throws ClassNotFoundException, SQLException {
        return orderDBAccess.getAllOrders();
    }
    
    @Override
    public boolean updateOrder(Order order) throws ClassNotFoundException, SQLException {
        return orderDBAccess.updateOrder(order);
    }
}
