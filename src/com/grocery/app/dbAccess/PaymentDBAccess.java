/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.grocery.app.dbAccess;

import com.grocery.app.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.grocery.app.model.Payment;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HaShaN
 */
public class PaymentDBAccess {
    public boolean addPayment(Payment payment) throws SQLException, ClassNotFoundException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement("insert into Payment values(?,?,?,?,?)");
        stm.setObject(1, payment.getPid());
        stm.setObject(2, payment.getOid());
        stm.setObject(3, payment.getTotal());
        stm.setObject(4, payment.getDiscount());
        stm.setObject(5, payment.getCash());
        return stm.executeUpdate()>0;
    }
    
    public Payment searchPayment(String payId) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet resultSet = stm.executeQuery("select * from Payment where PID='" + payId + "'");
        if (resultSet.next()) {
            return new Payment(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3)
            , resultSet.getDouble(4), resultSet.getDouble(5));
        }
        return null;
    }
    
    public boolean updatePayment(Payment payment) throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement("Update Payment set Total=?,Discount=?,Cash=? where PID=?");
        stm.setObject(1, payment.getTotal());
        stm.setObject(2, payment.getDiscount());
        stm.setObject(3, payment.getCash());
        stm.setObject(4, payment.getPid());
        return stm.executeUpdate() > 0;
    }
    
    public boolean deletePayment(String payId) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate("delete from Payment where PID='" + payId + "'") > 0;
    }
    
    public ArrayList<Payment> getAllPayments() throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        ResultSet resultSet = conn.createStatement().executeQuery("select * from Payment");
        ArrayList<Payment> payments = new ArrayList();
        while (resultSet.next()) {
            payments.add(new Payment(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3)
            , resultSet.getDouble(4), resultSet.getDouble(5)));
        }
        return payments;
    }
}
