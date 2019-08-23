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
import com.grocery.app.model.Order;

/**
 *
 * @author HaShaN
 */
public class OrderDBAccess {
    
    public boolean addOrder(Order order) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement("insert into Orders values(?, ?, ?)");
        stm.setObject(1, order.getId());
        stm.setObject(2, order.getCustomerId());
        stm.setObject(3, order.getDate());
        return stm.executeUpdate() > 0;
    }
    
    public Order searchOrder(String oid) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet resultSet = stm.executeQuery("select * from Orders where OID='" + oid + "'");
        if (resultSet.next()) {
            return new Order(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3));
        }
        return null;
    }
    
    public boolean updateOrder(Order order) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement("Update Orders set CustID=?,Date=? where OID=?");
        stm.setObject(1, order.getCustomerId());
        stm.setObject(2, order.getDate());
        stm.setObject(3, order.getId());
        return stm.executeUpdate() > 0;
    }
    
    public boolean deleteOrder(String oid) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate("delete from Orders where OID='" + oid + "'") > 0;
    }
    
    public ArrayList<Order> getAllOrders() throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        ResultSet rst = conn.createStatement().executeQuery("select * from Orders");
        ArrayList<Order> orderList = new ArrayList();
        while (rst.next()) {
            orderList.add(new Order(rst.getString(1), rst.getString(2), rst.getDate(3)));
        }
        return orderList;
    }
}
