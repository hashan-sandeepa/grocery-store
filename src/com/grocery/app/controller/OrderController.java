/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.app.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import com.grocery.app.model.Order;

/**
 *
 * @author HaShaN
 */
public interface OrderController{
    public boolean addOrder(Order order) throws ClassNotFoundException,SQLException;
    public Order searchOrder(String oid)throws ClassNotFoundException,SQLException;
    public boolean updateOrder(Order order) throws ClassNotFoundException, SQLException;
    public boolean deleteOrder(String oid)throws ClassNotFoundException,SQLException;
    public ArrayList<Order> getAllOrders()throws ClassNotFoundException,SQLException;
}
