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
import java.util.ArrayList;
import com.grocery.app.model.OrderDetail;

/**
 *
 * @author HaShaN
 */
public class OrderDetailDBAccess {
    public boolean addOrderDetail(ArrayList<OrderDetail> orderDetailList) throws ClassNotFoundException, SQLException {
        int res = 0;
        for (OrderDetail orderDetail : orderDetailList) {
            Connection conn=DBConnection.getDBConnection().getConnection();
            PreparedStatement prepareStatement = conn.prepareStatement("insert into OrderDetail values(?, ?, ?, ?)");
            prepareStatement.setObject(1, orderDetail.getOrderId());
            prepareStatement.setObject(2, orderDetail.getItemCode());
            prepareStatement.setObject(3, orderDetail.getQty());
            prepareStatement.setObject(4, orderDetail.getUnitPrice());
            res += prepareStatement.executeUpdate();
        }
        if (orderDetailList.size() == res) {
            return true;
        }
        return false;
    }
    
    public boolean deleteOrderDetail(String oid) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement("Delete from OrderDetail where OID=?");
        stm.setObject(1, oid);
        return stm.executeUpdate()>0;
    }
    
    public ArrayList<OrderDetail> searchOrderDetail(String id) throws ClassNotFoundException, SQLException {
        String sql = "select * from OrderDetail where OID='" + id + "'";
        PreparedStatement preparedStatement = DBConnection.getDBConnection()
                .getConnection().prepareStatement(sql);
        ResultSet rst = preparedStatement.executeQuery();
        ArrayList<OrderDetail> arrayList = new ArrayList<>();
        while (rst.next()) {
            OrderDetail orderDetail = new OrderDetail(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDouble(4));
            arrayList.add(orderDetail);
        }
        return arrayList;
    } 
}
