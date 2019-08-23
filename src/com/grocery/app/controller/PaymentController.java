/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.app.controller;

import java.sql.SQLException;
import com.grocery.app.model.Payment;
import java.util.ArrayList;

/**
 *
 * @author HaShaN
 */
public interface PaymentController{
    public boolean addPayment(Payment payment) throws ClassNotFoundException,SQLException;
    
    public Payment searchPayment(String payId)throws ClassNotFoundException,SQLException;
    
    public boolean deletePayment(String payId) throws ClassNotFoundException, SQLException;
    
    public boolean updatePayment(Payment payment) throws ClassNotFoundException, SQLException;
    
    public ArrayList<Payment> getAllPayments()throws ClassNotFoundException,SQLException;
}
