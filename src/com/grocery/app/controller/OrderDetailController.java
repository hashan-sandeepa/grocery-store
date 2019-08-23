/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.app.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import com.grocery.app.model.OrderDetail;

/**
 *
 * @author HaShaN
 */
public interface OrderDetailController{
    public boolean addOrderDetail(ArrayList<OrderDetail> list) throws ClassNotFoundException,SQLException;
    public ArrayList<OrderDetail> searchOrderDetail(String id) throws ClassNotFoundException,SQLException;
    public boolean deleteOrderDetail(String oid) throws ClassNotFoundException, SQLException;
}
