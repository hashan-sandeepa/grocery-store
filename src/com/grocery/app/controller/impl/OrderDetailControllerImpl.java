/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.app.controller.impl;

import com.grocery.app.controller.OrderDetailController;
import com.grocery.app.dbAccess.OrderDetailDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import com.grocery.app.model.OrderDetail;

/**
 *
 * @author HaShaN
 */
public class OrderDetailControllerImpl implements OrderDetailController{

    private final OrderDetailDBAccess orderDetailDBAccess=new OrderDetailDBAccess();
    public OrderDetailControllerImpl(){}
    
    @Override
    public boolean addOrderDetail(ArrayList<OrderDetail> list) throws ClassNotFoundException, SQLException {
        return orderDetailDBAccess.addOrderDetail(list);
    }

    @Override
    public ArrayList<OrderDetail> searchOrderDetail(String id) throws ClassNotFoundException, SQLException {
        return orderDetailDBAccess.searchOrderDetail(id);
    }

    @Override
    public boolean deleteOrderDetail(String oid) throws ClassNotFoundException, SQLException {
        return orderDetailDBAccess.deleteOrderDetail(oid);
    }
    
}
